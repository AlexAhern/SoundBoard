package com.ahernapps.android.pbsoundboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private final List<? extends MediaAsset> mResourceList;
    private final MediaPlayer mPlayer;
    private final MediaMetadataResolver mMediaMetadataResolver;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final SoundByteButton mButton;

        ViewHolder(Button v) {
            super(v);
            mButton = (SoundByteButton) v;
        }
    }

    SoundByteAdapter(MediaMetadataResolver mediaMetadataResolver,
                     MediaPlayer player,
                     List<? extends MediaAsset> resourceList) {
        mPlayer = player;
        mResourceList = resourceList;
        mMediaMetadataResolver = mediaMetadataResolver;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button v = (SoundByteButton) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soundbyte_button, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MediaAsset resourceID = mResourceList.get(position);
        holder.mButton.setMediaAsset(resourceID);
        holder.mButton.setPlayer(mPlayer);
    }

    @Override
    public int getItemCount() {
        return mResourceList.size();
    }


}
