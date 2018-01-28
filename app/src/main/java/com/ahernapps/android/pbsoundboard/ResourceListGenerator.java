package com.ahernapps.android.pbsoundboard;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class ResourceListGenerator {

    static List<Integer> generateList() {
        Field[] fields = R.raw.class.getFields();
        ArrayList<Integer> resourceList = new ArrayList<>();
        for (Field field : fields) {
            try {
                int id = field.getInt(null);
                resourceList.add(id);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resourceList;
    }
}
