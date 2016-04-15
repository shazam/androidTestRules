package com.shazam.android.test.rules;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;

class Modules {

    static Context getTargetContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    static Resources resources() {
        return getTargetContext().getResources();
    }

    static PackageManager packageManager() {
        return getTargetContext().getPackageManager();
    }
}
