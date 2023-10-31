plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.inshortsclone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.inshortsclone"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("${Dependencies.coreKtx}:${Versions.coreKtx}")
    implementation("${Dependencies.lifecycleRuntimeKtx}:${Versions.lifecycleRuntimeKtx}")
    implementation("${Dependencies.activityCompose}:${Versions.activityCompose}")
    implementation(platform("${Dependencies.composeBom}:${Versions.composeBom}"))
    implementation(Dependencies.ui)
    implementation(Dependencies.uiGraphics)
    implementation(Dependencies.uiToolingPreview)
    implementation(Dependencies.material3)
    implementation(project(Modules.utilities))
    implementation("${Dependencies.hiltAndroid}:${Versions.hiltAndroid}")
    implementation("${Dependencies.hiltNavigationCompose}:${Versions.hiltNavigationCompose}")
    implementation("${Dependencies.retrofit}:${Versions.retrofit}")
    implementation("${Dependencies.okhttp}:${Versions.okhttp}")
    implementation("${Dependencies.gsonConverter}:${Versions.gsonConverter}")
    implementation("${Dependencies.moshi}:${Versions.moshi}")
    implementation("${Dependencies.moshiConverter}:${Versions.moshiConverter}")
    implementation("${Dependencies.loggingInterceptor}:${Versions.loggingInterceptor}")
    implementation("${Dependencies.coroutinesCore}:${Versions.coroutines}")
    implementation("${Dependencies.coroutinesAndroid}:${Versions.coroutines}")
    implementation("${Dependencies.splashscreen}:${Versions.splashscreen}")
    implementation("${Dependencies.coil}:${Versions.coil}")
    implementation("dev.shreyaspatil:capturable:1.0.3")
    implementation("io.github.kaustubhpatange:kapture:1.0.0")
    kapt("${Dependencies.hiltAndroidCompiler}:${Versions.hiltAndroid}")
    kapt("${Dependencies.hiltCompiler}:${Versions.hiltCompiler}")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt{
    correctErrorTypes = true
}