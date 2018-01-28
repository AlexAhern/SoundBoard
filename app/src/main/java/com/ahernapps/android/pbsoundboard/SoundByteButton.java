package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class SoundByteButton extends android.support.v7.widget.AppCompatButton {
    private SoundByte soundByte;
    private MediaPlayer player;

    private final OnClickListener soundByteButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            player.play(soundByte.getResource());
        }
    };

    public SoundByteButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setMediaAsset(MediaAsset soundByte) {
        this.soundByte = (SoundByte) soundByte;
        this.setText(soundByte.getTitle());
        this.setOnClickListener(soundByteButtonClickListener);
    }

    public void setPlayer(MediaPlayer player) {
        this.player = player;
    }
}
