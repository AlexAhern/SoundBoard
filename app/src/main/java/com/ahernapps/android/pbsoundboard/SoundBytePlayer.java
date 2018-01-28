package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

public class SoundBytePlayer implements MediaPlayer {
    private SoundPool soundPool;
    private Context context;

    public SoundBytePlayer(Context context) {
        this.context = context;
        this.soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()).build();
    }

    @Override
    public void play(int resourceID) {
        soundPool.play(resourceID, 1, 1, 1, 0, 1);
    }

    @Override
    public int load(int resourceID) {
        return soundPool.load(context, resourceID, 1);
    }
}
