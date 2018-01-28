package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.media.SoundPool;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private final Context mContext;
    private final List<Integer> mResourceList;
    private final SoundPool mPlayer;
    private final MediaMetadataResolver mMediaMetadataResolver;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final SoundByteButton mButton;

        ViewHolder(Button v) {
            super(v);
            mButton = (SoundByteButton) v;
        }
    }

    SoundByteAdapter(Context context,
                     MediaMetadataResolver mediaMetadataResolver,
                     SoundPool player,
                     List<Integer> resourceList) {
        mContext = context;
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
        int resourceID = mResourceList.get(position);

        holder.mButton.setPlayer(mPlayer);
        holder.mButton.setSoundByte(
                new SoundByte(mMediaMetadataResolver.resolve(resourceID),
                mPlayer.load(mContext, resourceID, 1)));
    }

    @Override
    public int getItemCount() {
        return mResourceList.size();
    }


}
