package com.and.cmason.quoteadmin.base

/**
 * Created by cmason on 13/02/2018.
 */
open class BasePresenter<T: MvpContract.View>: MvpContract.Presenter<T> {
    var view: T? = null

    override fun onBind(view: T) {
        this.view = view
    }

    override fun onDestroy() {
        view = null
    }
}