package com.skoumal.teanity.app.persistence.exception

@Suppress("CanBeParameter", "MemberVisibilityCanBePrivate")
class UserNonExistantException(val id: String) : IllegalStateException("User[id=$id] doesn't exist")