package com.ahernapps.android.soundboard;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.annotation.NonNull;

public class SoundByte implements Comparable<SoundByte>{
    private Uri soundClipUri;
    private String title;

    public SoundByte(Context context, int resource) {
        this.soundClipUri = Uri.parse("android.resource://com.ahernapps.android.soundboard/" + resource);
        this.title = getTitleFromMetadata(context);
    }

    public String getTitle() {
        return title;
    }

    private String getTitleFromMetadata(Context context){
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(context, getSoundClipUri());
        return mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    }

    public Uri getSoundClipUri() {
        return soundClipUri;
    }

    @Override
    public int compareTo(@NonNull SoundByte soundByte) {
        return this.getTitle().compareTo(soundByte.getTitle());
    }
}
