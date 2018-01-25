package com.example.aherna01.soundboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SoundBoardActivity extends AppCompatActivity {
    private SoundByteListGenerator soundByteListGenerator = new SoundByteListGenerator(this);
    private MediaPlayer player = new SoundBytePlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<SoundByte> soundBytes = soundByteListGenerator.generateList();

        setContentView(R.layout.activity_sound_board);

        RecyclerView mRecyclerView = findViewById(R.id.soundbyte_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new SoundByteAdapter(player, soundBytes);
        mRecyclerView.setAdapter(mAdapter);
    }
}
