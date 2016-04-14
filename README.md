[![Build Status](https://travis-ci.org/shazam/androidTestRules.svg?branch=master)](https://travis-ci.org/shazam/androidTestRules)

Android Test Rules
===============
A collection of runtime conditions for ignoring Android Tests.

## How to conditionally ignore a test

```java
@Test
@IgnoreWhen(device = Form.Tablet.class)
public void phoneCanMakeACall() {
    // Run test that only applies to phones.
}
```

## How to add to your project
Simply add a dependency for the instrumentation tests' scope:
```groovy
dependencies {
    androidTestCompile('com.shazam:android-test-rules:1.0.0-SNAPSHOT')
}
```

If you are using a snapshot version also add:
```groovy
repositories {
    maven {
        url "https://oss.sonatype.org/content/repositories/snapshots/"
    }
}
```

Then in a test class where you wish to ignore certain tests, declare the following rule:
```java
@Rule
public ConditionalIgnoreRule conditionalIgnoreRule = new ConditionalIgnoreRule();
```

## How to contribute

Different conditions could be useful for various cases and users. To add a new condition, you can implement the `Condition` interface:
```java
public class NewCondition implements Condition {
    @Override
    public boolean isSatisfied() {
        // Implementation of condition goes here...
        return conditionIsSatisfied;
    }
}
```
It probably makes sense to organize individual conditions as inner static classes in classes that will act as the dimensions. For example, there could be parent classes like: Form, Architecture, InstalledApps, etc.
```java
public class Form {
    public static class Tablet implements Condition {
        @Override
        public boolean isSatisfied() {
            // Decide if this is a tablet;
        }
    }
    public static class Phone implements Condition {
        @Override
        public boolean isSatisfied() {
            // Decide if this is a phone;
        }

    }
}
```
Users of the library can then use code completion after the dimension they're interested in'.
