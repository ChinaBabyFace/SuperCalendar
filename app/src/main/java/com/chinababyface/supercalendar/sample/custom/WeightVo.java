package com.chinababyface.supercalendar.sample.custom;

/**
 * Created by renyuxiang on 2016/3/7.
 */
public class WeightVo {
    private float value;
    private int type;

    public WeightVo(float weight) {
        this.value = weight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
