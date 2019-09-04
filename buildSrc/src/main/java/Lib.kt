object Lib {

    val kotlin = Kotlin

    object Kotlin {
        private const val version = "1.3.50"
        private const val versionCoroutines = "1.2.2"

        val lib = kotlin("stdlib-jdk7", version)
        val gradle = kotlin("gradle-plugin", version)
        val coroutines = kotlinx("coroutines-android", versionCoroutines)
    }

    val androidx = AndroidX

    object AndroidX {
        val build = "com.android.tools.build:gradle:3.5.0"
        val room = androidx("room", "room-ktx", "2.2.0-beta01")
        val roomCompiler = androidx("room", "room-compiler", "2.2.0-beta01")
        val lifecycleCompiler = androidx("lifecycle", "lifecycle-compiler", "2.2.0-alpha02")
        val lifecycle = androidx("lifecycle", "lifecycle-extensions", "2.2.0-alpha02")
    }

    val navigation = Navigation

    object Navigation {
        private const val version = "2.1.0-alpha06"

        val build = androidx("navigation", "navigation-safe-args-gradle-plugin", version)
    }

    val square = Square

    object Square {
        private const val version = "2.6.1"

        val moshi = square("moshi", "moshi-kotlin", "1.8.0")
        val moshiCodegen = square("moshi", "moshi-kotlin-codegen", "1.8.0")
        val retrofit = square("retrofit2", "retrofit", version)
        val moshiConverter = square("retrofit2", "converter-moshi", version)
        val logging = square("okhttp3", "logging-interceptor", "4.1.0")
        val adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:"
    }

    val koin = Koin

    object Koin {
        private const val version = "2.0.1"

        val core = koin("android", version)
        val viewModel = koin("android-viewmodel", version)
    }

    const val kotpref = "com.chibatching.kotpref:kotpref:2.9.1"

    private fun kotlin(module: String, version: String? = null) =
        "org.jetbrains.kotlin:kotlin-$module${version?.let { ":$version" } ?: ""}"

    private fun kotlinx(module: String, version: String? = null) =
        "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

    private fun androidx(group: String, module: String, version: String) =
        "androidx.$group:$module:$version"

    private fun square(group: String, module: String, version: String) =
        "com.squareup.$group:$module:$version"

    private fun koin(module: String, version: String) =
        "org.koin:koin-$module:$version"

}