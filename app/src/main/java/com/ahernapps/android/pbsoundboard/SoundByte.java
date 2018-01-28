package com.ahernapps.android.pbsoundboard;

import android.support.annotation.NonNull;

class SoundByte implements Comparable<SoundByte>, MediaAsset {
    private final int resource;
    private final String title;

    SoundByte(String title, int mediaIdentifier) {
        this.resource = mediaIdentifier;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    int getResource() {
        return resource;
    }


    @Override
    public int compareTo(@NonNull SoundByte soundByte) {
        return this.getTitle().compareTo(soundByte.getTitle());
    }

}
