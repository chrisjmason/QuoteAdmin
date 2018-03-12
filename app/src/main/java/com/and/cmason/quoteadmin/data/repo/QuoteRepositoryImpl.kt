package com.and.cmason.quoteadmin.data.repo

import com.and.cmason.quoteadmin.data.QuoteService
import com.and.cmason.quoteadmin.data.models.QuoteApiResponse
import com.and.cmason.quoteadmin.data.models.QuoteModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by cmason on 13/02/2018.
 */
class QuoteRepositoryImpl(quoteService: QuoteService): QuoteRepository {
    var quoteService:QuoteService

    init {
        this.quoteService = quoteService
    }

    override fun getQuotes(): Single<List<QuoteModel>> = quoteService.getQuotes()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    override fun addQuote(quoteToAdd: QuoteModel): Single<QuoteApiResponse> = quoteService.addQuote(quoteToAdd)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    override fun updateQuote(quoteToUpdate: QuoteModel): Single<QuoteApiResponse> = quoteService.updateQuote(quoteToUpdate)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    override fun deleteQuote(quoteToDeleteId: String): Single<QuoteApiResponse> = quoteService.deleteQuote(quoteToDeleteId)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}