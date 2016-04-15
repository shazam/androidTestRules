package com.shazam.android.test.rules;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Architecture {

    /**
     * This will skip tests on an x86-based device even if there are other available ABIs.
     * Only do this if you know the code path you are testing is not supported on x86.
     */
    public static class X86 implements Condition {
        @Override
        public boolean isSatisfied() {
            return ArchitectureProvider.availableArchitectures().contains("x86");
        }
    }

    private static class ArchitectureProvider {
        private static Collection<String> availableArchitectures() {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                return cpuApi();
            } else {
                return availableApis();
            }
        }

        @SuppressWarnings("deprecation")
        private static Collection<String> cpuApi() {
            return singletonList(Build.CPU_ABI);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        private static Collection<String> availableApis() {
            return asList(Build.SUPPORTED_ABIS);
        }
    }
}
