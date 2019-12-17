buildscript {

    repositories { Repositories.with(this) }

    dependencies {
        classpath(Lib.androidx.build)
        classpath(Lib.kotlin.gradle)
        classpath(Lib.navigation.build)
        classpath(Lib.other.teanity)
    }

}

allprojects { repositories { Repositories.with(this) } }

apply(from = "android-setup.gradle")
apply(from = "android-tasks.gradle")