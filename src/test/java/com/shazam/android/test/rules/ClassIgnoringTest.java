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

import com.shazam.android.test.rules.ExampleConditions.AnyConfiguration;

import org.junit.*;

import static org.junit.Assert.fail;

@IgnoreWhen(device = AnyConfiguration.class)
public class ClassIgnoringTest {

    @Rule public ConditionalIgnoreRule rule = new ConditionalIgnoreRule();

    @Test
    public void confirmMethodsFromTestClassAreIgnored() {
        fail("This test should not have been executed because of its class annotation.");
    }

}
