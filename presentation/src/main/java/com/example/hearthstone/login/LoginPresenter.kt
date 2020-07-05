package com.example.hearthstone.login

import com.example.domain.core.CacheKey
import com.example.domain.interactors.EmailValidator
import com.example.domain.interactors.GetCacheObject
import com.example.domain.interactors.PutCacheObject
import com.example.domain.model.UserDomain
import com.example.hearthstone.core.Navigator
import com.example.iddogs.core.BasePresenter

class LoginPresenter(private val navigator: Navigator,
                     private val emailValidator: EmailValidator,
                     private val putCacheObject: PutCacheObject,
                     private val getCacheObject: GetCacheObject) : BasePresenter<LoginView>() {

    fun checkForCachedUser() {
        val currentUser = getCacheObject
            .with(CacheKey.USER, UserDomain::class.java)
            .execute()
        if (currentUser == null) {
            return
        } else {
            navigateMain()
        }
    }

    fun login(email : String, password : String) {
        if(isEmailValid(email) && isPasswordValid(password)) {
            cacheCurrentUser(email)
            navigateMain()
        } else {
            view?.showLoginError()
        }
    }

    private fun isEmailValid(email : String) : Boolean {
        return emailValidator
            .with(email)
            .execute()
    }

    private fun isPasswordValid(password: String) : Boolean {
        return password == "1234"
    }

    private fun cacheCurrentUser(email : String) {
        val user = UserDomain(email)
        putCacheObject
            .with(user)
            .execute()
    }

    private fun navigateMain() {
        navigator.navigateMain()
    }
}