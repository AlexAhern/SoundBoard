package com.ahernapps.android.soundboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.io.IOException;

public class SoundByteButton extends android.support.v7.widget.AppCompatButton {
    private SoundByte soundByte;
    private SoundBytePlayer player;

    OnClickListener soundByteButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                if (player.isPlaying()) {
                    player.stop();
                    player.reset();
                }
                player.setDataSource(SoundByteButton.this.getContext(), soundByte.getSoundClipUri());
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.play();
        }
    };

    public SoundByteButton(Context context) {
        super(context);
    }

    public SoundByteButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSoundByte(SoundByte soundByte) throws IOException {
        this.soundByte = soundByte;
        this.setText(soundByte.getTitle());
        this.setOnClickListener(soundByteButtonClickListener);
    }

    public SoundByte getSoundByte() {
        return soundByte;
    }

    public void setPlayer(SoundBytePlayer player) {
        this.player = player;
    }
}
