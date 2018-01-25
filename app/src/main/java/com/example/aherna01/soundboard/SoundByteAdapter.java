package com.example.aherna01.soundboard;

import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private ArrayList<SoundByte> mSoundBytes;
    private SoundBytePlayer mPlayer;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SoundByteButton mButton;
        public ViewHolder(Button v){
            super(v);
            mButton = (SoundByteButton) v;
        }
    }

    public SoundByteAdapter(MediaPlayer player, ArrayList<SoundByte> soundBytes){
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
            holder.mButton.setSoundByte(mSoundBytes.get(position));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mSoundBytes.size();
    }


}
