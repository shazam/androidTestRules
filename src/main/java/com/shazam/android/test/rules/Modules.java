package com.shazam.android.test.rules;

import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;

class Modules {

    static Resources resources() {
        return InstrumentationRegistry.getTargetContext().getResources();
    }
}
