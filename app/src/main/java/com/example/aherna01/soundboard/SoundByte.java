package com.example.aherna01.soundboard;

import android.net.Uri;

/**
 * Created by aherna01 on 22/01/2018.
 */

public class SoundByte {
    private String title;
    public int resource;

    public SoundByte(String title, int file){
        this.title = title;
        this.resource = file;
    }

    public String getTitle() {
        return title;
    }

    public Uri getResourcePath() {
        return Uri.parse("android.resource://com.example.aherna01.soundboard/"+ resource);
    }
}
