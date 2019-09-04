package com.skoumal.teanity.app.data

object Constants {

    val isDebug = BuildConfig.DEBUG
    val isIntegration = BuildConfig.BUILD_TYPE == "integration"
    val isTest = BuildConfig.BUILD_TYPE == "test"
    val isRelease = BuildConfig.BUILD_TYPE == "release"

    // ---

    const val accessKey = "b2aca767ea814ee517645716525ccb49bfdfbe05a8bf1f2dfea7830e6e303483"

}