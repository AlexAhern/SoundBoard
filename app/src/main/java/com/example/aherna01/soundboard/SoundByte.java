package com.example.aherna01.soundboard;

import android.app.Activity;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

/**
 * Created by aherna01 on 22/01/2018.
 */

public class SoundByte {
    private Activity activity;
    private Uri soundClipUri;

    public SoundByte(Activity activity, int resource) {
        this.soundClipUri = getResourcePath(resource);
    }

    public String getTitle() {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(activity, soundClipUri);
        return mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    }


    public Uri getSoundClipUri() {
        return soundClipUri;
    }

    public Uri getResourcePath(int resource) {
        return Uri.parse("android.resource://com.example.aherna01.soundboard/" + resource);
    }

}
