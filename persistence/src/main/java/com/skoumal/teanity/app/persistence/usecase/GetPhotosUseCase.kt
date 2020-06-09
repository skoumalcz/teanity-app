package com.skoumal.teanity.app.persistence.usecase

import androidx.lifecycle.LiveData
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.persistence.dao.PhotoDao
import com.skoumal.teanity.component.CompoundUseCase

class GetPhotosUseCase internal constructor(
    private val dao: PhotoDao
) : CompoundUseCase<Unit, List<Photo>>() {

    override fun observe(params: Unit): LiveData<List<Photo>?> {
        return dao.observeAll()
    }

    override suspend fun execute(input: Unit): List<Photo> {
        return dao.all()
    }
}