package com.and.cmason.quoteadmin.data

import com.and.cmason.quoteadmin.data.models.QuoteApiResponse
import com.and.cmason.quoteadmin.data.models.QuoteModel
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by cmason on 13/02/2018.
 */
interface QuoteService
{
    @GET("quotes")
    fun getQuotes(): Single<List<QuoteModel>>

    @POST("quote")
    fun addQuote(@Body quote: QuoteModel): Single<QuoteApiResponse>

    @PUT("quote")
    fun updateQuote(@Body quote: QuoteModel): Single<QuoteApiResponse>

    @DELETE("quote/{id}")
    fun deleteQuote(@Path("id") id: String): Single<QuoteApiResponse>
}