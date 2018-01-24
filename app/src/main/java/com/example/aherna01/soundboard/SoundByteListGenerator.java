package com.example.aherna01.soundboard;

import android.app.Activity;

import java.lang.reflect.Field;

/**
 * Created by aherna01 on 24/01/2018.
 */

public class SoundByteListGenerator {
    private final Activity activity;

    public SoundByteListGenerator(Activity activity){
        this.activity = activity;

    }
    public SoundByte[] generateList(){
        Field[] fields = R.raw.class.getFields();
        SoundByte[] soundByteList = new SoundByte[fields.length];
        for(int count=0; count < fields.length; count++){
            soundByteList[count] = new SoundByte(activity, Integer.parseInt(fields[count].getName()));
        }
        return soundByteList;
    }
}
