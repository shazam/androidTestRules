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

import com.shazam.android.test.conditions.Condition;
import com.shazam.android.test.statement.NoOpStatement;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * A rule that checks for the {@link IgnoreWhen} annotation in test classes or methods and causes them to skip
 * if their {@link Condition Conditions} are satisfied.
 */
public class ConditionalIgnoreRule implements TestRule {
    private static final Statement NO_OP_STATEMENT = new NoOpStatement();

    @Override
    public Statement apply(Statement base, Description description) {
        return (shouldIgnore(description) ? NO_OP_STATEMENT : base);
    }

    private boolean shouldIgnore(Description description) {
        return shouldIgnoreClass(description) || shouldIgnoreMethod(description);
    }

    private boolean shouldIgnoreClass(Description description) {
        Class<?> clazz = description.getTestClass();
        do {
            if (shouldIgnoreAnnotatedElement(clazz)) {
                return true;
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        return false;
    }

    private boolean shouldIgnoreMethod(Description description) {
        try {
            Method method = description.getTestClass().getMethod(description.getMethodName(), (Class<?>[]) null);
            return shouldIgnoreAnnotatedElement(method);
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private boolean shouldIgnoreAnnotatedElement(AnnotatedElement annotatedElement) {
        if (!annotatedElement.isAnnotationPresent(IgnoreWhen.class)) {
            return false;
        }

        IgnoreWhen ignoreWhen = annotatedElement.getAnnotation(IgnoreWhen.class);
        for (Class<? extends Condition> clazz : ignoreWhen.device()) {
            try {
                Condition condition = clazz.newInstance();
                if (condition.isSatisfied()) {
                    return true;
                }
            } catch (InstantiationException e) {
                throw new RuntimeException("Ensure a public no-arg constructor is available in your Condition class. " +
                        "If the Condition is an inner class, make sure it's static", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Ensure the no-arg constructor in your Condition class is public", e);
            }
        }

        return false;
    }

}
