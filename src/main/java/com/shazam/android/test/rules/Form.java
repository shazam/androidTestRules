/*
 * Copyright 2015 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.shazam.android.test.rules;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.DisplayMetrics;

public class Form {

    public static class Tablet implements Condition {

        @Override
        public boolean isSatisfied() {
            Context targetContext = InstrumentationRegistry.getTargetContext();
            DisplayMetrics displayMetrics = targetContext.getResources().getDisplayMetrics();
            int width = dps(displayMetrics.widthPixels, displayMetrics.densityDpi);
            int height = dps(displayMetrics.heightPixels, displayMetrics.densityDpi);
            return width >= 600 || height >= 600;
        }

    }

    private static int dps(int dimension, int densityDpi) {
        return (160 * dimension) / densityDpi;
    }
}
