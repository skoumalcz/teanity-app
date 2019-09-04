package com.skoumal.teanity.app.persistence.usecase

import com.skoumal.teanity.app.model.internal.User
import com.skoumal.teanity.app.persistence.dao.UserDao
import com.skoumal.teanity.persistence.UseCase
import kotlinx.coroutines.Dispatchers

class UserInsertUseCase internal constructor(
    private val dao: UserDao
) : UseCase<List<User>, Unit>() {

    override val dispatcher = Dispatchers.IO

    override suspend fun execute(input: List<User>) {
        dao.insert(input)
    }

}