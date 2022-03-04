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
    implementation("androidx.core:core-ktx:1.7.0")

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.4.1")

    //  Material design
    implementation("com.google.android.material:material:1.5.0")

    // UI Component
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // ViewBinding Property delegate
    val view_binding_property_delegate = "1.5.3"
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")
    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    // Coroutine Lifecycle Scope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.fragment:fragment-ktx:1.4.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.3")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40")
}