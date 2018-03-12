package com.and.cmason.quoteadmin.addquote

import com.and.cmason.quoteadmin.base.MvpContract
import com.and.cmason.quoteadmin.data.models.QuoteModel

/**
 * Created by cmason on 14/02/2018.
 */
interface AddQuoteContract {
    interface Presenter: MvpContract.Presenter<View>{
        fun addQuote(quoteToAdd: QuoteModel)

        fun updateQuote(quoteToUpdate: QuoteModel)
    }

    interface View: MvpContract.View{
        fun quoteAdded()
        fun quoteNotAdded(message: String)
    }
}