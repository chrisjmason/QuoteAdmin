package com.and.cmason.quoteadmin.dagger.modules

import com.and.cmason.quoteadmin.data.QuoteService
import com.and.cmason.quoteadmin.util.LoggingInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cmason on 07/02/2018.
 */
@Module
class NetworkModule{
    @Named("QuotesRetrofit")
    @Provides
    @Singleton
    fun provideQuotesRetrofit(): Retrofit {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val client = OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .build()

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl("http://quoteapi.chrisjmason.com/")
                .build()
    }

    @Provides
    @Singleton
    fun provideQuoteService(@Named("QuotesRetrofit") retrofit: Retrofit): QuoteService = retrofit.create(QuoteService::class.java)
}