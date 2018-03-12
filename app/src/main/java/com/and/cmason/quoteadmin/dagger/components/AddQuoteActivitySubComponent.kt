package com.and.cmason.quoteadmin.dagger.components

import com.and.cmason.quoteadmin.addquote.AddQuoteActivity
import dagger.Subcomponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

/**
 * Created by cmason on 14/02/2018.
 */

@Subcomponent
interface AddQuoteActivitySubComponent: AndroidInjector<AddQuoteActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<AddQuoteActivity>()
}