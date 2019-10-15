object Lib {

    //region Access values
    val kotlin = Kotlin
    val androidx = AndroidX
    val navigation = Navigation
    val square = Square
    val koin = Koin
    val other = Other
    //endregion

    private object V {
        const val kotlin = "1.3.50"
        const val coroutines = "1.2.2"
        const val build = "3.5.0"
        const val room = "2.2.0-beta01"
        const val lifecycle = "2.2.0-alpha02"
        const val navigation = "2.1.0-alpha06"
        const val moshi = "1.8.0"
        const val retrofit = "2.6.1"
        const val logging = "4.1.0"
        const val koin = "2.0.1"
        const val kotpref = "2.9.1"
    }

    object Kotlin {
        val lib = kotlin("stdlib-jdk7", V.kotlin)
        val gradle = kotlin("gradle-plugin", V.kotlin)
        val coroutines = kotlinx("coroutines-android", V.coroutines)
    }

    object AndroidX {
        val build = "com.android.tools.build:gradle:${V.build}"
        val room = androidx("room", "room-ktx", V.room)
        val roomCompiler = androidx("room", "room-compiler", V.room)
        val lifecycleCompiler = androidx("lifecycle", "lifecycle-compiler", V.lifecycle)
        val lifecycle = androidx("lifecycle", "lifecycle-extensions", V.lifecycle)
    }

    object Navigation {
        val build = androidx("navigation", "navigation-safe-args-gradle-plugin", V.navigation)
    }

    object Square {
        val moshi = square("moshi", "moshi-kotlin", V.moshi)
        val moshiCodegen = square("moshi", "moshi-kotlin-codegen", V.moshi)
        val retrofit = square("retrofit2", "retrofit", V.retrofit)
        val moshiConverter = square("retrofit2", "converter-moshi", V.retrofit)
        val logging = square("okhttp3", "logging-interceptor", V.logging)
    }

    object Koin {
        val core = koin("android", V.koin)
        val viewModel = koin("android-viewmodel", V.koin)
    }

    object Other {
        const val kotpref = "com.chibatching.kotpref:kotpref:${V.kotpref}"
    }


    @JvmStatic
    @JvmOverloads
    fun teanity(module: String, version: String = "1.+") =
        "com.skoumal.teanity:$module:$version"

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