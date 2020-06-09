object Lib {

    //region Access values
    val v = V
    val kotlin = Kotlin
    val androidx = AndroidX
    val navigation = Navigation
    val square = Square
    val other = Other
    //endregion

    object V {
        const val kotlin = "1.3.72"
        const val coroutines = "1.3.2"
        const val build = "4.0.0"
        const val navigation = "2.2.0-rc02"
        const val logging = "4.2.2"
        const val kotpref = "2.9.1"
        const val teanity = "1.2-SNAPSHOT"
        const val paging = "2.1.2"
    }

    object Kotlin {
        val lib = kotlin("stdlib-jdk7", V.kotlin)
        val gradle = kotlin("gradle-plugin", V.kotlin)
        val coroutines = kotlinx("coroutines-android", V.coroutines)
    }

    object AndroidX {
        val build = "com.android.tools.build:gradle:${V.build}"
        val paging = androidx("paging", "paging-runtime-ktx", V.paging)
    }

    object Navigation {
        val build = androidx("navigation", "navigation-safe-args-gradle-plugin", V.navigation)
    }

    object Square {
        val logging = square("okhttp3", "logging-interceptor", V.logging)
    }

    object Other {
        const val teanity = "com.skoumal:teanity-plugin:1.0.7"
        const val kotpref = "com.chibatching.kotpref:kotpref:${V.kotpref}"
    }

    private fun kotlin(module: String, version: String? = null) =
        "org.jetbrains.kotlin:kotlin-$module${version?.let { ":$version" } ?: ""}"

    private fun kotlinx(module: String, version: String? = null) =
        "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

    private fun androidx(group: String, module: String, version: String) =
        "androidx.$group:$module:$version"

    private fun square(group: String, module: String, version: String) =
        "com.squareup.$group:$module:$version"

}