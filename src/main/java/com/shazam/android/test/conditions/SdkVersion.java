/*
 * Copyright 2015 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.shazam.android.test.conditions;

import android.os.Build;

public class SdkVersion {

    public static class IceCreamSandwichAndEarlier implements Condition {
        @Override
        public boolean isSatisfied() {
            return isEqualOrLessThan(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1);
        }
    }

    public static class JellyBeanAndEarlier implements Condition {
        @Override
        public boolean isSatisfied() {
            return isEqualOrLessThan(Build.VERSION_CODES.JELLY_BEAN_MR2);
        }
    }

    private static boolean isEqualOrLessThan(int apiLevel) {
        return apiLevel <= Build.VERSION.SDK_INT;
    }
}
