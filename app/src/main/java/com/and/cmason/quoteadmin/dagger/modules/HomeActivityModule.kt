package com.and.cmason.quoteadmin.dagger.modules

import android.app.Activity
import com.and.cmason.quoteadmin.dagger.components.HomeActivitySubComponent
import com.and.cmason.quoteadmin.data.QuoteService
import com.and.cmason.quoteadmin.data.repo.QuoteRepository
import com.and.cmason.quoteadmin.data.repo.QuoteRepositoryImpl
import com.and.cmason.quoteadmin.home.HomeActivity
import com.and.cmason.quoteadmin.home.HomeContract
import com.and.cmason.quoteadmin.home.HomePresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by cmason on 13/02/2018.
 */

@Module(subcomponents = arrayOf(HomeActivitySubComponent::class))
abstract class HomeActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindHomeActivityInjectorFactory(builder:HomeActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providePresenter(repo: QuoteRepository): HomePresenter = HomePresenter(repo)
    }
}