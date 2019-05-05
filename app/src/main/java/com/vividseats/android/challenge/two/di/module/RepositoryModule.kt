package com.vividseats.android.challenge.two.di.module

import com.vividseats.android.challenge.two.data.remote.api.HomeCardsAPI
import com.vividseats.android.challenge.two.data.repository.HomeCardRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideHomeCardRepository(homeCardWebApi: HomeCardsAPI) = HomeCardRepository(homeCardWebApi)
}