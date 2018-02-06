package com.ahernapps.android.pbsoundboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class SoundByteAdapter extends RecyclerView.Adapter<SoundByteAdapter.ViewHolder> {
    private final List<? extends MediaAsset> mResourceList;
    private final OnButtonClickListener onButtonClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final Button mButton;

        ViewHolder(Button v) {
            super(v);
            mButton = v;
        }
    }

    SoundByteAdapter(OnButtonClickListener listener,
                     List<? extends MediaAsset> resourceList) {
        onButtonClickListener = listener;
        mResourceList = resourceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button v = (Button) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soundbyte_button, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MediaAsset mediaAsset = mResourceList.get(position);

        holder.mButton.setText(mediaAsset.getTitle());
        holder.mButton.setOnClickListener(view -> onButtonClickListener.onButtonClick(mediaAsset));
    }

    @Override
    public int getItemCount() {
        return mResourceList.size();
    }


}
