package com.skoumal.teanity.app.di

import com.skoumal.teanity.app.ui.HomeActivity.Companion.homeModule
import com.skoumal.teanity.app.ui.detail.DetailFragment.Companion.detailModule
import com.skoumal.teanity.app.ui.login.LoginFragment.Companion.loginModule
import com.skoumal.teanity.app.ui.pictures.PicturesFragment.Companion.picturesModule

val appModules = listOf(
    homeModule, picturesModule, detailModule, loginModule
)