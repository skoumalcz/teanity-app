package com.skoumal.teanity.app.persistence.usecase

import com.skoumal.teanity.app.model.internal.User
import com.skoumal.teanity.app.persistence.dao.UserDao
import com.skoumal.teanity.component.CompoundUseCase

class GetUserByIdUseCase internal constructor(
    private val dao: UserDao
) : CompoundUseCase<String, User>() {

    override fun observe(params: String) = dao.observeById(params)

    override suspend fun execute(input: String) = dao.byId(input)!!
}