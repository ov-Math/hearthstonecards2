package com.example.iddogs.core

abstract class BasePresenter<T : BaseView> {

    internal var view: T? = null

    open fun attachView(view: T) {
        this.view = view
    }
}