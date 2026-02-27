plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.ktlint)
}

android {
    namespace = "com.daejong.ci_cdpractice"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.daejong.ci_cdpractice"
        minSdk = 24
        targetSdk = 36
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

    buildFeatures {
        dataBinding = true
    }
}

ktlint {
    android.set(true) // 안드로이드 권장 스타일 가이드 적용
    ignoreFailures.set(false) // 스타일 위반 시 빌드를 실패시켜 CI에서 감지하게 함
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // MockK 테스트 라이브러리 추가
    testImplementation(libs.test.mockk)
    // 코루틴 테스트가 필요한 경우를 대비해 추가 권장
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
}