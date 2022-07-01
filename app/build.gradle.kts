plugins {
    id("com.android.application")
    id("kotlin-android")

    id("androidx.navigation.safeargs.kotlin")

    //kapt
    id("kotlin-kapt")

    // Hilt
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.rickandmortyarchitecture"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        viewBinding = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    //  Core
    implementation(libs.androidx.core.ktx)

    // Appcompat
    implementation(libs.androidx.appcompat)

    //  Material design
    implementation(libs.material)

    // UI Component
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // ViewBinding Property delegate
    // | kirich1409 | To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6")

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    // Coroutine Lifecycle Scope
    // |Live Data
    implementation(libs.androidx.lifecycle.livedata)
    // |ViewModel
    implementation(libs.androidx.lifecycle.viewmodel)
    // | RunTime
    implementation(libs.androidx.lifecycle.runtime)

    //Fragment Ktx
    implementation(libs.androidx.fragment.ktx)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.9")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.9")
    // Glide
    implementation("com.github.bumptech.glide:glide:4.13.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.40")
    //Shimmer Layout
    implementation("com.facebook.shimmer:shimmer:0.5.0")

}