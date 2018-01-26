package com.ahernapps.android.pbsoundboard;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SoundBoardActivity extends AppCompatActivity {
    private SoundPool player = new SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()).build();

    private SoundByteListGenerator soundByteListGenerator
            = new SoundByteListGenerator(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        ArrayList<SoundByte> soundBytes = soundByteListGenerator.generateList();

        RecyclerView mRecyclerView = findViewById(R.id.soundbyte_recyclerview);

        RecyclerView.LayoutManager mLayoutManager =
                new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new SoundByteAdapter(player, soundBytes);
        mRecyclerView.setAdapter(mAdapter);
    }
}
