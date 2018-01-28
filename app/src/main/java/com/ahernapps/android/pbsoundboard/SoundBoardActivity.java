package com.ahernapps.android.pbsoundboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class SoundBoardActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;

    private final MediaPlayer player = new SoundBytePlayer(this);
    private MediaMetadataResolver mediaMetadataResolver = new SoundMetadataResolver(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        PACKAGE_NAME = getApplicationContext().getPackageName();

        List<Integer> soundResources = ResourceListGenerator.generateList();

        RecyclerView mRecyclerView = findViewById(R.id.soundbyte_recyclerview);

        RecyclerView.LayoutManager mLayoutManager =
                new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new SoundByteAdapter(
                this,
                mediaMetadataResolver,
                player
                , soundResources);
        mRecyclerView.setAdapter(mAdapter);


    }
}
