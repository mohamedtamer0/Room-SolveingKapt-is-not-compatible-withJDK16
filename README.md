# Room-SolveingKapt-is-not-compatible-withJDK16

- build.gradle (Module)
```gradle
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
}


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = '11'
    }
    
    
    ///OR
    
        compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
    
    
    
    
    
        //Room
    def room_version = "2.2.6"
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:2.2.6"
    implementation "androidx.room:room-rxjava2:$room_version"




    //rxjava
    def rxJavaVersion = '2.1.1'
    implementation "io.reactivex.rxjava2:rxandroid:$rxJavaVersion"
    implementation "io.reactivex.rxjava2:rxjava:$rxJavaVersion"

    
```



- build.gradle (Project)
```gradle

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:7.0.0"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
    
```

-gradle.properties

```gradle

org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8 --illegal-access=permit
kapt.use.worker.api=false
    
```

