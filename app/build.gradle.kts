@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.aruzeta.tmdb"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.aruzeta.tmdb"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "com.aruzeta.tmdb.HiltTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "TMDB_API_READ_ACCESS_TOKEN", getTmdbApiReadAccessToken())
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composeVersion = properties["composeVersion"]
    val lifecycleVersion = properties["lifecycleVersion"]
    val daggerHiltVersion = properties["daggerHiltVersion"]
    val retrofit2Version = properties["retrofit2Version"]
    val coroutinesVersion = properties["coroutinesVersion"]
    val androidCoreVersion = properties["androidCoreVersion"]
    val accompanistVersion = properties["accompanistVersion"]
    val datastorePreferencesVersion = properties["datastorePreferencesVersion"]
    val activityComposeVersion = properties["activityComposeVersion"]
    val material3Version = properties["material3Version"]
    val navigationComposeVersion = properties["navigationComposeVersion"]
    val hiltNavigationComposeVersion = properties["hiltNavigationComposeVersion"]
    val okhttp3LoggingInterceptorVersion = properties["okhttp3LoggingInterceptorVersion"]
    val coilComposeVersion = properties["coilComposeVersion"]
    val junitVersion = properties["junitVersion"]
    val androidxJunitVersion = properties["androidxJunitVersion"]
    val espressoCoreVersion = properties["espressoCoreVersion"]

    // Core
    implementation("androidx.core:core-ktx:$androidCoreVersion")

    // System UI
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")

    // Datastore
    implementation("androidx.datastore:datastore-preferences:$datastorePreferencesVersion")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")

    // Compose
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material3:material3:$material3Version")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:$navigationComposeVersion")

    // Hilt
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")
    androidTestImplementation("com.google.dagger:hilt-android-testing:$daggerHiltVersion")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")

    // Hilt navigation
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit2Version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")

    // OkHttp3
    androidTestImplementation("com.squareup.okhttp3:logging-interceptor:$okhttp3LoggingInterceptorVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    // Coil Images
    implementation("io.coil-kt:coil-compose:$coilComposeVersion")

    // Others
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$androidxJunitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
}

fun getTmdbApiReadAccessToken(): String = rootProject.file("secrets.properties").let {
    if (it.exists()) Properties().let { props ->
        props.load(FileInputStream(it))
        props.getProperty("TMDB_API_READ_ACCESS_TOKEN")
    } else throw FileNotFoundException()
}
