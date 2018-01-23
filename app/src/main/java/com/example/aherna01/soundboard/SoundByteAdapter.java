package com.example.aherna01.soundboard;

import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;

/**
 * Created by aherna01 on 22/01/2018.
 */

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private SoundByte[] mSoundBytes;
    private SoundBytePlayer mPlayer;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SoundByteButton mButton;
        public ViewHolder(Button v){
            super(v);
            mButton = (SoundByteButton) v;
        }
    }

    public SoundByteAdapter(MediaPlayer player, SoundByte[] soundBytes){
        mPlayer = (SoundBytePlayer) player;
        mSoundBytes = soundBytes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button v = (SoundByteButton) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soundbyte_button, parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.mButton.setPlayer(mPlayer);
            holder.mButton.setSoundByte(mSoundBytes[position]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mSoundBytes.length;
    }


}
