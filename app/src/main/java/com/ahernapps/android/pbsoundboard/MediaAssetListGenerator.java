package com.ahernapps.android.pbsoundboard;


import java.util.ArrayList;

@FunctionalInterface
interface MediaAssetListGenerator {
    ArrayList<? extends MediaAsset> generateList(MediaPlayer player, MediaMetadataResolver mediaMetadataResolver);
}
