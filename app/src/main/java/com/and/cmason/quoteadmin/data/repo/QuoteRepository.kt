package com.and.cmason.quoteadmin.data.repo

import com.and.cmason.quoteadmin.data.models.QuoteApiResponse
import com.and.cmason.quoteadmin.data.models.QuoteModel
import io.reactivex.Single

/**
 * Created by cmason on 13/02/2018.
 */
interface QuoteRepository {
    fun getQuotes(): Single<List<QuoteModel>>

    fun addQuote(quoteToAdd: QuoteModel): Single<QuoteApiResponse>

    fun updateQuote(quoteToUpdate: QuoteModel): Single<QuoteApiResponse>

    fun deleteQuote(quoteToDeleteId: String): Single<QuoteApiResponse>
}