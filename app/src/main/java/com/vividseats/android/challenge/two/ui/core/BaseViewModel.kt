package com.vividseats.android.challenge.two.ui.core

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}