package com.vividseats.android.challenge.two.ui

import android.app.Activity
import android.app.Application
import com.vividseats.android.challenge.two.di.component.ApplicationComponent
import com.vividseats.android.challenge.two.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class ChallengeTwoApplication : Application(), HasActivityInjector {
    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        component = DaggerApplicationComponent.builder()
            .application(this)
            .build()

        component.inject(this)

        super.onCreate()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}