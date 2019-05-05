package com.vividseats.android.challenge.two.ui.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (data: T) -> Unit) {
    this.observe(owner, Observer { data ->
        data?.let(observer)
    })
}