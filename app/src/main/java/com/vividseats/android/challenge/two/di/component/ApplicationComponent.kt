package com.vividseats.android.challenge.two.di.component

import android.app.Application
import com.vividseats.android.challenge.two.di.module.ActivityModule
import com.vividseats.android.challenge.two.di.module.HttpModule
import com.vividseats.android.challenge.two.di.module.RepositoryModule
import com.vividseats.android.challenge.two.di.module.ViewModelModule
import com.vividseats.android.challenge.two.ui.ChallengeTwoApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        HttpModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ChallengeTwoApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(application: ChallengeTwoApplication)
}