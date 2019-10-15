package com.skoumal.teanity.app.di

import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.ui.HomeViewModel
import com.skoumal.teanity.app.ui.detail.DetailViewModel
import com.skoumal.teanity.app.ui.login.LoginViewModel
import com.skoumal.teanity.app.ui.pictures.PicturesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val appMainModule = module {
    viewModel { HomeViewModel() }
    viewModel { PicturesViewModel(get(), get()) }
    viewModel { (photo: Photo) -> DetailViewModel(photo, get()) }
    viewModel { LoginViewModel() }
}

val appModules = listOf(
    appMainModule
)