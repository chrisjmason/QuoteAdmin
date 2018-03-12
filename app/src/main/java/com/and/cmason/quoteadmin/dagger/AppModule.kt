package com.and.cmason.quoteadmin.dagger

import android.app.Application
import android.content.Context
import com.and.cmason.quoteadmin.data.QuoteService
import com.and.cmason.quoteadmin.data.repo.QuoteRepository
import com.and.cmason.quoteadmin.data.repo.QuoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by cmason on 12/02/2018.
 */
@Module
abstract class AppModule {
    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideRepo(quoteService: QuoteService): QuoteRepository = QuoteRepositoryImpl(quoteService)
    }
}