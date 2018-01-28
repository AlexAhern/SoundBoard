package com.ahernapps.android.pbsoundboard;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import static com.ahernapps.android.pbsoundboard.SoundBoardActivity.PACKAGE_NAME;

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private final MediaMetadataRetriever mMmr;
    private final Context mContext;
    private final List<Integer> mResourceList;
    private final SoundPool mPlayer;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final SoundByteButton mButton;

        ViewHolder(Button v) {
            super(v);
            mButton = (SoundByteButton) v;
        }
    }

    SoundByteAdapter(Context context, SoundPool player, MediaMetadataRetriever mmr,
                     List<Integer> resourceList) {
        mMmr = mmr;
        mContext = context;
        mPlayer = player;
        mResourceList = resourceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button v = (SoundByteButton) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soundbyte_button, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mButton.setPlayer(mPlayer);
        mMmr.setDataSource(mContext,  Uri.parse("android.resource://" + PACKAGE_NAME + "/" +
                mResourceList.get(position)));

        holder.mButton.setSoundByte(new SoundByte(
                mMmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE),
                mPlayer.load(mContext, mResourceList.get(position),1)));
    }

    @Override
    public int getItemCount() {
        return mResourceList.size();
    }


}
