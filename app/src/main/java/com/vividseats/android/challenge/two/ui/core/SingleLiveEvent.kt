package com.vividseats.android.challenge.two.ui.core

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean

/**
    A lifecycle aware observable that only emits new updates after subscription. Can be used for one off events such as
    displayingToasts or for navigation events.

    This fixes and issue with standard LiveData and instances where an item is emitted a second time(or more) due to a
    configuration change. This only calls the observable if there's ax explicit call to setValue or call()

    Note: Only one observer is going to be notified of emissions
// **/

class SingleLiveEvent<DataType> : MutableLiveData<DataType>() {
    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<DataType>) {
        if (hasActiveObservers()) {
            Log.i(this.javaClass.simpleName,"Multiple observers registered but only one will be notified of changes")
        }

        super.observe(owner, Observer { value ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(value)
            }
        })
    }

    @MainThread
    override fun setValue(value: DataType?) {
        pending.set(true)
        super.setValue(value)
    }

    /**Cleaner invocation for when [DataType] is Unit**/
    @MainThread
    fun call() {
        value = null
    }
}
