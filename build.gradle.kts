buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        val gradleVersion = properties["gradleVersion"]
        val kotlinVersion = properties["kotlinVersion"]
        val daggerHiltVersion = properties["daggerHiltVersion"]

        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$daggerHiltVersion")
    }
}
