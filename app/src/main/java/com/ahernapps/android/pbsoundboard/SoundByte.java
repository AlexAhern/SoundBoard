package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.annotation.NonNull;

public class SoundByte implements Comparable<SoundByte> {
    public int getResource() {
        return resource;
    }

    private int resource;
    private int soundID;
    private String title;

    public SoundByte(Context context, int resource) {
        this.resource = resource;
        this.title = getTitleFromMetadata(context);
    }

    public String getTitle() {
        return title;
    }

    private String getTitleFromMetadata(Context context) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(context, getSoundClipUri());
        return mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    }

    public Uri getSoundClipUri() {
        return Uri.parse("android.resource://com.ahernapps.android.pbsoundboard/" + resource);
    }

    @Override
    public int compareTo(@NonNull SoundByte soundByte) {
        return this.getTitle().compareTo(soundByte.getTitle());
    }

    public void setSoundID(int soundID) {
        this.soundID = soundID;
    }

    public int getSoundID() {
        return soundID;
    }
}
