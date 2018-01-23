package com.example.aherna01.soundboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.io.IOException;

/**
 * Created by aherna01 on 22/01/2018.
 */

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
                player.setDataSource(SoundByteButton.this.getContext(), soundByte.getResourcePath());
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
        this.setText(soundByte.getTitle());
        this.soundByte = soundByte;
        this.setOnClickListener(soundByteButtonClickListener);
    }

    public SoundByte getSoundByte() {
        return soundByte;
    }

    public void setPlayer(SoundBytePlayer player) {
        this.player = player;
    }
}
