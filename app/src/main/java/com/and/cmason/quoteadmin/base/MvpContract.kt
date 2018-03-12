package com.and.cmason.quoteadmin.base

/**
 * Created by cmason on 13/02/2018.
 */
interface MvpContract {
    interface Presenter<T: View>{
        fun onBind(view: T)
        fun onDestroy()
    }

    interface View{

    }
}