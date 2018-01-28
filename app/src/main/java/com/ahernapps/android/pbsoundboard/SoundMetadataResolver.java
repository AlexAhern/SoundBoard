package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

import static com.ahernapps.android.pbsoundboard.SoundBoardActivity.PACKAGE_NAME;

public class SoundMetadataResolver implements MediaMetadataResolver {
    private MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    private Context context;

    SoundMetadataResolver(Context context) {
        this.context = context;
    }

    @Override
    public String resolve(int resourceID) {
        mediaMetadataRetriever.setDataSource(context,
                Uri.parse("android.resource://" + PACKAGE_NAME + "/" + resourceID));
        return mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    }
}
