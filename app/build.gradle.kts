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
    implementation(libs.androidx.hilt.common)
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
    implementation("androidx.work:work-runtime-ktx:2.10.1")
    implementation("androidx.hilt:hilt-work:1.2.0")

    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.material3.android)

    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.haze)
    implementation(libs.haze.materials)

    implementation(libs.androidx.navigation.compose)
    implementation (libs.androidx.runtime.livedata)

    // Use KSP instead of KAPT
    ksp(libs.androidx.hilt.compiler)
    ksp(libs.hilt.compiler)
    ksp(libs.androidx.room.compiler)
    implementation(libs.hilt.android)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    // jetpack glance
    // For AppWidgets support
    implementation (libs.androidx.glance.appwidget)

    // For interop APIs with Material 3
    implementation (libs.androidx.glance.material3)
    implementation (libs.compose.charts)
}