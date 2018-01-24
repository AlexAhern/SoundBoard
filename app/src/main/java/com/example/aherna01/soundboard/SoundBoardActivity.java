package com.example.aherna01.soundboard;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SoundBoardActivity extends AppCompatActivity {
    private SoundByteListGenerator soundByteListGenerator = new SoundByteListGenerator(this);
    private MediaPlayer player = new SoundBytePlayer();
    private SoundByte[] soundBytes = soundByteListGenerator.generateList();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        mRecyclerView = findViewById(R.id.soundbyte_recyclerview);

        mLayoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SoundByteAdapter(player, soundBytes);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //logic to cancel current playback if new one is clicked after rotation - minor?
        //either access previous instance or delete this one altogether
    }
}
