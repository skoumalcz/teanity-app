package com.skoumal.teanity.app.persistence.usecase

import com.skoumal.teanity.app.persistence.dao.PhotoDao
import com.skoumal.teanity.component.UseCase
import com.skoumal.teanity.tools.annotation.SubjectsToFutureChange

@OptIn(SubjectsToFutureChange::class)
class GetPhotoCountUseCase internal constructor(
    private val dao: PhotoDao
) : UseCase<Unit, Int>() {

    override suspend fun execute(input: Unit): Int {
        return dao.count()
    }

}