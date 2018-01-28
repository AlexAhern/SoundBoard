package com.ahernapps.android.pbsoundboard;

import android.support.annotation.NonNull;

class SoundByte implements Comparable<SoundByte> {
    private final int soundID;
    private final String title;

    SoundByte(String title, int soundID) {
        this.soundID = soundID;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    int getSoundID() {
        return soundID;
    }


    @Override
    public int compareTo(@NonNull SoundByte soundByte) {
        return this.getTitle().compareTo(soundByte.getTitle());
    }

}
