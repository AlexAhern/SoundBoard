package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class MediaAssetButton extends android.support.v7.widget.AppCompatButton {
    private MediaAsset mediaAsset;
    private MediaPlayer player;

    private final OnClickListener mediaAssetButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            player.play(mediaAsset.getResource());
        }
    };

    public MediaAssetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setMediaAsset(MediaAsset mediaAsset) {
        this.mediaAsset = mediaAsset;
        this.setText(mediaAsset.getTitle());
        this.setOnClickListener(mediaAssetButtonClickListener);
    }

    public void setPlayer(MediaPlayer player) {
        this.player = player;
    }
}
