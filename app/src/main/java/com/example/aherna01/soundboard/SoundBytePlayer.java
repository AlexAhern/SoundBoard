package com.example.aherna01.soundboard;

import android.media.AudioAttributes;
import android.media.MediaPlayer;

import java.io.IOException;

public class SoundBytePlayer extends MediaPlayer {


    public SoundBytePlayer() {
        super();
        this.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build());

        this.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        });
    }

    public void play() {
        try {
            if (this.isPlaying()) {
                this.stop();
            }
            this.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.start();
    }
}
