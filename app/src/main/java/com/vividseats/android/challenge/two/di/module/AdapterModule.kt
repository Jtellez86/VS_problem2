package com.vividseats.android.challenge.two.di.module

import com.vividseats.android.challenge.two.ui.main.HomeCardsListAdapter
import dagger.Module
import dagger.Provides


@Module
class AdapterModule {
    @Provides
    fun provideMyResourceListAdapter(): HomeCardsListAdapter = HomeCardsListAdapter()
}