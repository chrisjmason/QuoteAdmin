package com.and.cmason.quoteadmin.dagger.modules

import android.app.Activity
import com.and.cmason.quoteadmin.addquote.AddQuoteActivity
import com.and.cmason.quoteadmin.addquote.AddQuoteContract
import com.and.cmason.quoteadmin.addquote.AddQuotePresenter
import com.and.cmason.quoteadmin.dagger.components.AddQuoteActivitySubComponent
import com.and.cmason.quoteadmin.data.repo.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by cmason on 14/02/2018.
 */

@Module(subcomponents = arrayOf(AddQuoteActivitySubComponent::class))
abstract class AddQuoteActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(AddQuoteActivity::class)
    abstract fun bindAddQuoteActivityInjectorFactory(builder: AddQuoteActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideAddQuotePresenter(repository: QuoteRepository):AddQuoteContract.Presenter = AddQuotePresenter(repository)
    }
}