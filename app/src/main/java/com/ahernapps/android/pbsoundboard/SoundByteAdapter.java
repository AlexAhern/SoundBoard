package com.ahernapps.android.pbsoundboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private final List<? extends MediaAsset> mResourceList;
    private final MediaPlayer mPlayer;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final MediaAssetButton mButton;

        ViewHolder(Button v) {
            super(v);
            mButton = (MediaAssetButton) v;
        }
    }

    SoundByteAdapter(MediaPlayer player,
                     List<? extends MediaAsset> resourceList) {
        mPlayer = player;
        mResourceList = resourceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button v = (MediaAssetButton) LayoutInflater.from(parent.getContext())
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
