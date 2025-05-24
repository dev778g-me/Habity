plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //[KSP]
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization") version "2.1.20"
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
    //[icons]
    implementation(libs.androidx.material.icons.extended)



    //[Google Fonts]
    implementation (libs.androidx.ui.text.google.fonts)
    //[flow layout]
    implementation (libs.accompanist.flowlayout)

    //[Serialization]
    implementation(libs.kotlinx.serialization.json)
    //[Navigation]
    val nav_version = "2.8.9"
    implementation( libs.androidx.navigation.compose)
    //[KSP]
    ksp(libs.androidx.room.compiler)
    //[Room]
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
}