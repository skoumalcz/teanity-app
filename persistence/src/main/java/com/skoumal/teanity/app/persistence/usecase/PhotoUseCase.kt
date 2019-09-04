package com.skoumal.teanity.app.persistence.usecase

import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.persistence.dao.PhotoDao
import com.skoumal.teanity.persistence.LiveUseCase

class PhotoUseCase internal constructor(
    private val dao: PhotoDao
) : LiveUseCase<Unit, List<Photo>>() {

    override fun execute(input: Unit) = dao.all()

}