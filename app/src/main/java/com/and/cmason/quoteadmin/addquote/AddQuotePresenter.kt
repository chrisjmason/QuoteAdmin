package com.and.cmason.quoteadmin.addquote

import android.util.Log
import com.and.cmason.quoteadmin.base.BasePresenter
import com.and.cmason.quoteadmin.data.models.QuoteApiResponse
import com.and.cmason.quoteadmin.data.models.QuoteModel
import com.and.cmason.quoteadmin.data.repo.QuoteRepository

/**
 * Created by cmason on 14/02/2018.
 */
class AddQuotePresenter(repo: QuoteRepository): BasePresenter<AddQuoteContract.View>(), AddQuoteContract.Presenter {
    var repo: QuoteRepository

    init {
        this.repo = repo
    }

    override fun addQuote(quoteToAdd: QuoteModel) {
        repo.addQuote(quoteToAdd)
                .subscribe({ t: QuoteApiResponse? ->
                    Log.d("Quote added response", t.toString())
                    if(t?.status == 200){
                        view?.quoteAdded()
                    }else{
                        view?.quoteNotAdded("Error adding quote")
                    }
                },  {e ->
                    Log.d("Error printed", e.toString())
                    view?.quoteNotAdded("Error adding quote")
                } )
    }

    override fun updateQuote(quoteToUpdate: QuoteModel) {
        Log.d("quote to update", quoteToUpdate.toString())
        repo.updateQuote(quoteToUpdate)
                .subscribe({ t ->
                    if(t?.status == 200){
                        view?.quoteAdded()
                    }else{
                        view?.quoteNotAdded("Error adding quote")
                    }
                },  {e ->
                    Log.d("Error printed", e.toString())
                    view?.quoteNotAdded("Error updating quote")
                } )
    }
}