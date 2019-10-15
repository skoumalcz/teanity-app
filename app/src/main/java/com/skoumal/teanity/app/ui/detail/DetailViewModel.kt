package com.skoumal.teanity.app.ui.detail

import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.persistence.usecase.GetUserByIdUseCase
import com.skoumal.teanity.app.view.AppViewModel

class DetailViewModel(
    val photo: Photo,
    private val users: GetUserByIdUseCase
) : AppViewModel() {

    val user = users(photo.uid)

}