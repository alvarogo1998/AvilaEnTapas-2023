plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.agalobr.ex04_tapasview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.agalobr.ex04_tapasview"
        minSdk = 27
        targetSdk = 34
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    val lifecycleVersion = "2.6.2"

    // Ciclo Vida: ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    implementation("androidx.activity:activity-ktx:1.8.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //Skeleton
    val skeletonVersion = "5.0.0"
    implementation ("com.faltenreich:skeletonlayout:$skeletonVersion")

    //CardView
    implementation ("androidx.cardview:cardview:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}