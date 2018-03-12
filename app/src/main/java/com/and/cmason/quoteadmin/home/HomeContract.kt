package com.and.cmason.quoteadmin.home

import com.and.cmason.quoteadmin.base.MvpContract
import com.and.cmason.quoteadmin.data.models.QuoteModel

/**
 * Created by cmason on 13/02/2018.
 */
interface HomeContract {
    interface View: MvpContract.View{
        fun showList(quoteList: List<QuoteModel>)
        fun quoteDeleted()
        fun quoteNotDeleted(message: String)
    }

    interface Presenter: MvpContract.Presenter<View>{
        fun getList()
        fun deleteQuote(quoteToDeleteId: String)
    }
}