package com.shazam.android.test.conditions;

import android.os.Build;

public class Model {

    public static class Nexus10 implements Condition {
        @Override
        public boolean isSatisfied() {
            return modelEquals("Nexus 10");
        }
    }

    public static class Nexus4 implements Condition {
        @Override
        public boolean isSatisfied() {
            return modelEquals("Nexus 4");
        }
    }

    private static boolean modelEquals(String other) {
        return Build.MODEL.equals(other);
    }
}
