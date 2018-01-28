package com.ahernapps.android.pbsoundboard;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

class SoundByteListGenerator implements MediaAssetListGenerator {

     public ArrayList<? extends MediaAsset> generateList(MediaPlayer player, MediaMetadataResolver mediaMetadataResolver) {
        Field[] fields = R.raw.class.getFields();
        ArrayList<SoundByte> resourceList = new ArrayList<>();
        for (Field field : fields) {
            try {
                int resourceID = field.getInt(null);
                resourceList.add(new SoundByte(mediaMetadataResolver.resolve(resourceID),
                        player.load(resourceID)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(resourceList);
        return resourceList;
    }
}
