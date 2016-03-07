package com.chinababyface.framework.kit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class BitmapUploadKit {

    private static void revitionImageSizeHD(String picfile, int size, int quality) throws IOException {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!FileKit.doesExisted(picfile)) {
            throw new FileNotFoundException(picfile == null ? "null" : picfile);
        }
        if (!BitmapKit.isBitmapValidByPath(picfile)) {
            throw new IOException("");
        }
        int photoSizesOrg = 2 * size;
        FileInputStream input = new FileInputStream(picfile);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(input, null, opts);
        try {
            input.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        int rate = 0;
        for (int i = 0; ; i++) {
            if ((opts.outWidth >> i <= photoSizesOrg) && (opts.outHeight >> i <= photoSizesOrg)) {
                rate = i;
                break;
            }
        }
        opts.inSampleSize = ((int) Math.pow(2.0D, rate));
        opts.inJustDecodeBounds = false;

        Bitmap temp = safeDecodeBimtapFile(picfile, opts);
        if (temp == null) {
            throw new IOException("Bitmap decode error!");
        }
        FileKit.deleteDependon(picfile);
        FileKit.makesureFileExist(picfile);

        int org = temp.getWidth() > temp.getHeight() ? temp.getWidth() : temp.getHeight();
        float rateOutPut = size / org;
        if (rateOutPut < 1.0F) {
            Bitmap outputBitmap;
            for (; ; ) {
                try {
                    outputBitmap = Bitmap.createBitmap((int) (temp.getWidth() * rateOutPut), (int) (temp.getHeight() * rateOutPut), Bitmap.Config.ARGB_8888);
                    break;
                } catch (OutOfMemoryError e) {
                    System.gc();
                    rateOutPut = (float) (rateOutPut * 0.8D);
                }
            }

            if (outputBitmap == null) {
                temp.recycle();
            } else {
                Canvas canvas = new Canvas(outputBitmap);
                Matrix matrix = new Matrix();
                matrix.setScale(rateOutPut, rateOutPut);
                canvas.drawBitmap(temp, matrix, new Paint());
                temp.recycle();
                temp = outputBitmap;
            }
        }
        FileOutputStream output = new FileOutputStream(picfile);
        if ((opts != null) && (opts.outMimeType != null) && (opts.outMimeType.contains("png"))) {
            temp.compress(Bitmap.CompressFormat.PNG, quality, output);
        } else {
            temp.compress(Bitmap.CompressFormat.JPEG, quality, output);
        }
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        temp.recycle();
    }

    private static void revitionImageSize(String picfile, int size, int quality) throws IOException {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!FileKit.doesExisted(picfile)) {
            throw new FileNotFoundException(picfile == null ? "null" : picfile);
        }
        if (!BitmapKit.isBitmapValidByPath(picfile)) {
            throw new IOException("");
        }
        FileInputStream input = new FileInputStream(picfile);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(input, null, opts);
        try {
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int rate = 0;
        for (int i = 0; ; i++) {
            if ((opts.outWidth >> i <= size) && (opts.outHeight >> i <= size)) {
                rate = i;
                break;
            }
        }
        opts.inSampleSize = ((int) Math.pow(2.0D, rate));
        opts.inJustDecodeBounds = false;

        Bitmap temp = safeDecodeBimtapFile(picfile, opts);
        if (temp == null) {
            throw new IOException("Bitmap decode error!");
        }
        FileKit.deleteDependon(picfile);
        FileKit.makesureFileExist(picfile);
        FileOutputStream output = new FileOutputStream(picfile);
        if ((opts != null) && (opts.outMimeType != null) && (opts.outMimeType.contains("png"))) {
            temp.compress(Bitmap.CompressFormat.PNG, quality, output);
        } else {
            temp.compress(Bitmap.CompressFormat.JPEG, quality, output);
        }
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        temp.recycle();
    }

    public static boolean revitionPostImageSize(Context context, String picFile) {
        try {
            if (NetKit.isWifi(context)) {
                revitionImageSizeHD(picFile, 1600, 75);
            } else {
                revitionImageSize(picFile, 1024, 75);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static Bitmap safeDecodeBimtapFile(String bmpFile, BitmapFactory.Options opts) {
        BitmapFactory.Options optsTmp = opts;
        if (optsTmp == null) {
            optsTmp = new BitmapFactory.Options();
            optsTmp.inSampleSize = 1;
        }
        Bitmap bmp = null;
        FileInputStream input = null;

        for (int i = 0; i < 5; ) {
            try {
                input = new FileInputStream(bmpFile);
                bmp = BitmapFactory.decodeStream(input, null, opts);
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i++;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                optsTmp.inSampleSize *= 2;
                try {
                    input.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (FileNotFoundException e) {
            }
        }
        return bmp;
    }
}
