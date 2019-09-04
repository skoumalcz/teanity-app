package com.skoumal.teanity.app.persistence.usecase

import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.persistence.dao.PhotoDao
import com.skoumal.teanity.persistence.UseCase
import kotlinx.coroutines.Dispatchers

class PhotoInsertUseCase internal constructor(
    private val dao: PhotoDao
) : UseCase<List<Photo>, Unit>() {

    override val dispatcher = Dispatchers.IO

    override suspend fun execute(input: List<Photo>) {
        dao.insert(input)
    }

}