plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.mostafij.androidweatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mostafij.androidweatherapp"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

/*
* This dependency seems like a new thing in `Android`.
* In past, it used to be something like this ->
* `implementation ("com.squareup.retrofit2:converter-gson:2.9.0")`
*
* But now, they added a new `TOML` based system. Where
*  `$<PROJECT_ROOT>/gradle/libs.versions.toml`
* file contains all the dependency path, versions, and all the necessary details.
* And we just connect those here. Like this ->
*  `implementation (libs.converter.gson)`
* Here, `libs` is the libraries sections from the toml file.
* */
dependencies {
    // * -> Utilities (Kotlin, Compose etc.)
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    implementation(libs.material3)
    implementation(libs.androidx.material3.window.size)
    implementation(libs.androidx.material3.adaptive.navigation.suite)

    // * -> To add the lifecycle tracking ability!
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // * -> Packages that are used for testing!
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // * -> Retrofit (for network handling!)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
}