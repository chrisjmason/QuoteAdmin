package com.and.cmason.quoteadmin.home

import android.util.Log
import com.and.cmason.quoteadmin.base.BasePresenter
import com.and.cmason.quoteadmin.data.models.QuoteApiResponse
import com.and.cmason.quoteadmin.data.models.QuoteModel
import com.and.cmason.quoteadmin.data.repo.QuoteRepository

/**
 * Created by cmason on 13/02/2018.
 */
class HomePresenter(repository: QuoteRepository): BasePresenter<HomeContract.View>(), HomeContract.Presenter {
    var repo: QuoteRepository

    init{
        this.repo = repository
    }

    override fun getList(){
        repo.getQuotes()
                .subscribe({ t1: List<QuoteModel> -> view?.showList(t1) })
    }

    override fun deleteQuote(quoteToDeleteId:String) {
        repo.deleteQuote(quoteToDeleteId)
                .subscribe({ t: QuoteApiResponse? ->
                    if(t?.status == 200){
                        view?.quoteDeleted()
                    }else{
                        view?.quoteNotDeleted("Error deleting quote")
                    }
                },  {e ->
                    Log.d("Error printed", e.toString())
                    view?.quoteNotDeleted("Error deleting quote")
                } )
    }
}