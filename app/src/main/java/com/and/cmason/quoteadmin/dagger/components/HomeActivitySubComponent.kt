package com.and.cmason.quoteadmin.dagger.components

import com.and.cmason.quoteadmin.home.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by cmason on 13/02/2018.
 */
@Subcomponent
interface HomeActivitySubComponent: AndroidInjector<HomeActivity>{
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<HomeActivity>()
}