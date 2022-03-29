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
    //  Core
    implementation(libs.androidx.core.ktx)

    // Appcompat
    implementation("androidx.appcompat:appcompat:1.4.1")

    //  Material design
    implementation(libs.material)

    // UI Component
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // ViewBinding Property delegate

    // ViewBindingPropertyDelegate
    // | kirich1409 | To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6")
    // ViewModel
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.viewmodel)

    // Navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")
    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    // Coroutine Lifecycle Scope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation(libs.androidx.lifecycle.runtime)

    implementation(libs.androidx.fragment.ktx)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp
    implementation("com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.6")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation(libs.okhttp.client)
    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    //Shimmer Layout
    implementation("com.facebook.shimmer:shimmer:0.5.0")

}