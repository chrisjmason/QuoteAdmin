package com.and.cmason.quoteadmin.dagger

import com.and.cmason.quoteadmin.QuoteApplication
import com.and.cmason.quoteadmin.dagger.modules.AddQuoteActivityModule
import com.and.cmason.quoteadmin.dagger.modules.HomeActivityModule
import com.and.cmason.quoteadmin.dagger.modules.NetworkModule
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by cmason on 13/02/2018.
 */

@Component(modules = arrayOf(AndroidInjectionModule::class,
        NetworkModule::class,
        HomeActivityModule::class,
        AddQuoteActivityModule::class,
        AppModule::class))
@Singleton
interface AppComponent {
    fun inject(app: QuoteApplication)
}