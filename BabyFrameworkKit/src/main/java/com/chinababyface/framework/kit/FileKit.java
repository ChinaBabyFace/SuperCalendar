package com.chinababyface.framework.kit;

import android.graphics.Bitmap;
import android.text.TextUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ChinaBabyFace
 *         github.com/ChinaBabyFace
 */
public final class FileKit {

    public static boolean deleteDependon(File file, int maxRetryCount) {
        int retryCount = 1;
        maxRetryCount = maxRetryCount < 1 ? 5 : maxRetryCount;
        boolean isDeleted = false;
        if (file != null) {
            do {
                if (!(isDeleted = file.delete())) {
                    retryCount++;
                }
            }
            while ((!isDeleted) && (retryCount <= maxRetryCount) && (file.isFile()) && (file.exists()));
        }
        return isDeleted;
    }

    public static void mkdirs(File dir_) {
        if (dir_ == null) {
            return;
        }
        if ((!dir_.exists()) && (!dir_.mkdirs())) {
            throw new RuntimeException("fail to make " + dir_.getAbsolutePath());
        }
    }

    public static void createNewFile(File file_) {
        if (file_ == null) {
            return;
        }
        if (!__createNewFile(file_)) {
            throw new RuntimeException(file_.getAbsolutePath() + " doesn't be created!");
        }
    }

    public static void delete(File f) {
        if ((f != null) && (f.exists()) && (!f.delete())) {
            throw new RuntimeException(f.getAbsolutePath() + " doesn't be deleted!");
        }
    }

    public static boolean __createNewFile(File file_) {
        if (file_ == null) {
            return false;
        }
        makesureParentExist(file_);
        if (file_.exists()) {
            delete(file_);
        }
        try {
            return file_.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteDependon(String filepath, int maxRetryCount) {
        if (TextUtils.isEmpty(filepath)) {
            return false;
        }
        return deleteDependon(new File(filepath), maxRetryCount);
    }

    public static boolean deleteDependon(String filepath) {
        return deleteDependon(filepath, 0);
    }

    public static boolean doesExisted(File file) {
        return (file != null) && (file.exists());
    }

    public static boolean doesExisted(String filepath) {
        if (TextUtils.isEmpty(filepath)) {
            return false;
        }
        return doesExisted(new File(filepath));
    }

    public static void makesureParentExist(File file_) {
        if (file_ == null) {
            return;
        }
        File parent = file_.getParentFile();
        if ((parent != null) && (!parent.exists())) {
            mkdirs(parent);
        }
    }

    public static void makesureFileExist(File file) {
        if (file == null) {
            return;
        }
        if (!file.exists()) {
            makesureParentExist(file);
            createNewFile(file);
        }
    }

    public static void makesureFileExist(String filePath_) {
        if (filePath_ == null) {
            return;
        }
        makesureFileExist(new File(filePath_));
    }

    public static boolean saveBitmap(Bitmap bitmap, final String path) {

        File photoFile = new File(path);
        if (!photoFile.getParentFile().exists()) {
            photoFile.getParentFile().mkdirs();
        }

        BufferedOutputStream bos;
        try {
            photoFile.createNewFile();
            bos = new BufferedOutputStream(new FileOutputStream(photoFile));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bos.flush();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
