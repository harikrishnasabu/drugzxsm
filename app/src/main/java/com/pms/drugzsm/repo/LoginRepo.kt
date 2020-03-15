package com.pms.drugzsm.repo

import com.pms.drugzsm.datamodels.Login
import com.pms.drugzsm.dao.LoginDao

class LoginRepo constructor( val userDao: LoginDao) {

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun setLoginInfo(login: Login) {
        userDao.setLoginInfo(login)
    }

    fun getLoginInfo() = userDao.getLoginInfo()

    companion object {
        // Singleton instantiation
        @Volatile private var instance: LoginRepo? = null

        fun getInstance(userDao: LoginDao) =
            instance ?: synchronized(this) {
                instance
                    ?: LoginRepo(userDao).also { instance = it }
            }
    }
}