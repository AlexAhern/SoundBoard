package com.ahernapps.android.soundboard;

import android.content.Context;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class SoundByteListGenerator {
    private final Context context;

    public SoundByteListGenerator(Context context){
        this.context = context;

    }

    public ArrayList<SoundByte> generateList(){
        Field[] fields = R.raw.class.getFields();
        ArrayList<SoundByte> soundByteList = new ArrayList<>();
        for(int count=0; count < fields.length; count++){
            try {
                soundByteList.add(new SoundByte(context, fields[count].getInt(null)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(soundByteList);
        return soundByteList;
    }
}
