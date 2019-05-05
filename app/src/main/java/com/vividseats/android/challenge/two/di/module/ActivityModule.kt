package com.vividseats.android.challenge.two.di.module

import com.vividseats.android.challenge.two.di.ActivityScope
import com.vividseats.android.challenge.two.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity
}