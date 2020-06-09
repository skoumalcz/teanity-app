package com.skoumal.teanity.app.data.usecase

import com.skoumal.teanity.app.model.inbound.divide
import com.skoumal.teanity.app.network.Unsplash
import com.skoumal.teanity.app.persistence.usecase.PutPhotoUseCase
import com.skoumal.teanity.app.persistence.usecase.PutUserUseCase
import com.skoumal.teanity.component.CompoundUseCase
import kotlinx.coroutines.Dispatchers

class PutRemotePhotosUseCase internal constructor(
    private val api: Unsplash,
    private val photo: PutPhotoUseCase,
    private val user: PutUserUseCase
) : CompoundUseCase<PutRemotePhotosUseCase.Params, Unit>() {

    override val dispatcher = Dispatchers.IO

    override suspend fun execute(input: Params) {
        val items = api.getPhotos(input.page, input.perPage)
            .map { it.divide() }
            .toMap()

        user.now(items.values.toList())
        photo.now(items.keys.toList())
    }

    data class Params(
        val page: Int,
        val perPage: Int = 10
    )

}