package com.example.domain.interactors

class EmailValidator {

    private var email : String? = null

    fun with(email : String?) : EmailValidator {
        this.email = email
        return this
    }

    fun execute() : Boolean {
        if (email.isNullOrBlank())
            return false
        val emailRegex = Regex("[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+")
        return email!!.contains(emailRegex)
    }
}