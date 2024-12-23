package com.example.jetpackcomposeegitim

import javax.inject.Inject

interface UserRepository {
    suspend fun getUser(username: String, password: String): User?
    suspend fun insertUser(user: User)
}

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    private val users = mutableListOf<User>()

    override suspend fun getUser(username: String, password: String): User? {
        return users.find { it.username == username && it.password == password }
    }

    override suspend fun insertUser(user: User) {
        users.add(user)
    }
}
