package com.shazam.android.test.conditions;

import android.content.res.Configuration;

import static com.shazam.android.test.conditions.Modules.resources;

public class Orientation {

    public static class Landscape implements Condition {
        @Override
        public boolean isSatisfied() {
            return Configuration.ORIENTATION_LANDSCAPE == getCurrentOrientation();
        }
    }

    public static class Portrait implements Condition {
        @Override
        public boolean isSatisfied() {
            return Configuration.ORIENTATION_PORTRAIT == getCurrentOrientation();
        }
    }

    private static int getCurrentOrientation() {
        return resources().getConfiguration().orientation;
    }
}
