package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.view.View;

import java.io.IOException;

public class SoundByteButton extends android.support.v7.widget.AppCompatButton {
    private SoundByte soundByte;
    private SoundPool player;
    private Context context;

    OnClickListener soundByteButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            player.play(soundByte.getSoundID(), 1, 1, 1, 0, 1);
        }
    };

    public SoundByteButton(Context context) {
        super(context);
        this.context = context;
    }

    public SoundByteButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setSoundByte(SoundByte soundByte) throws IOException {
        this.soundByte = soundByte;
        this.setText(soundByte.getTitle());
        this.soundByte.setSoundID(player.load(context, soundByte.getResource(), 1));
        this.setOnClickListener(soundByteButtonClickListener);
    }

    public void setPlayer(SoundPool player) {
        this.player = player;
    }
}
