package com.skoumal.teanity.app.persistence.usecase

import com.skoumal.teanity.app.model.internal.User
import com.skoumal.teanity.app.persistence.dao.UserDao
import com.skoumal.teanity.component.LiveUseCase

class GetUserByIdUseCase internal constructor(
    private val dao: UserDao
) : LiveUseCase<String, User>() {

    override fun execute(input: String) = dao.byId(input)

}