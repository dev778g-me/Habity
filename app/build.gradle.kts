plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //[KSP]
    id("com.google.devtools.ksp")

    kotlin("plugin.serialization") version "2.1.20"
    //[Hilt]
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.dev.habity"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dev.habity"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    val room_version = "2.6.1"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.material.icons.extended)
    implementation("androidx.compose.material3:material3-android:1.4.0-alpha14")
    // Remove this: implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.kotlinx.serialization.json)

    implementation("dev.chrisbanes.haze:haze:1.6.1")
    implementation("dev.chrisbanes.haze:haze-materials:1.6.1")

    val nav_version = "2.8.9"
    implementation(libs.androidx.navigation.compose)
    implementation ("androidx.compose.runtime:runtime-livedata:1.8.2")

    // Use KSP instead of KAPT
    ksp("androidx.hilt:hilt-compiler:1.1.0")
    ksp("com.google.dagger:hilt-compiler:2.56.2")
    ksp(libs.androidx.room.compiler)
    implementation("com.google.dagger:hilt-android:2.56.2")

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
}