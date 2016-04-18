package com.shazam.android.test.conditions;

import android.os.Build;

public class Device {
    public static class Genymotion implements Condition {

        @Override
        public boolean isSatisfied() {
            return deviceEquals("vbox86p");
        }
    }

    private static boolean deviceEquals(String device) {
        return Build.DEVICE.equals(device);
    }
}
