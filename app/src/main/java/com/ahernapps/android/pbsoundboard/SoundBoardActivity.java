package com.ahernapps.android.pbsoundboard;

import android.media.AudioAttributes;
import android.media.MediaMetadataRetriever;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class SoundBoardActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;

    private final SoundPool player = new SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()).build();

    private final MediaMetadataRetriever mmr = new MediaMetadataRetriever();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        PACKAGE_NAME = getApplicationContext().getPackageName();

        List<Integer> soundResources = ResourceListGenerator.generateList();

        RecyclerView mRecyclerView = findViewById(R.id.soundbyte_recyclerview);



        RecyclerView.LayoutManager mLayoutManager =
                new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new SoundByteAdapter(this, player, mmr
                , soundResources);
        mRecyclerView.setAdapter(mAdapter);


    }
}
