package com.ahernapps.android.pbsoundboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class SoundBoardActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;
    ArrayList<? extends MediaAsset> soundResources;
    MediaAssetListGenerator mediaAssetListGenerator = new SoundByteListGenerator();

    private final MediaPlayer player = new SoundBytePlayer(this);
    private MediaMetadataResolver mediaMetadataResolver = new SoundMetadataResolver(this);

    private OnButtonClickListener onButtonClickListener = asset -> player.play(asset.getResource());

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);

        PACKAGE_NAME = getApplicationContext().getPackageName();
        soundResources = mediaAssetListGenerator.generateList(player, mediaMetadataResolver);

        RecyclerView mRecyclerView = findViewById(R.id.soundbyte_recyclerview);

        RecyclerView.LayoutManager mLayoutManager =
                new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new SoundByteAdapter(onButtonClickListener, soundResources);
        mRecyclerView.setAdapter(mAdapter);


    }
}


interface OnButtonClickListener {
    void onButtonClick(MediaAsset asset);
}
