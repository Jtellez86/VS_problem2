package com.vividseats.android.challenge.two.ui.main

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.vividseats.android.challenge.two.data.local.model.HomeCard
import com.vividseats.android.challenge.two.data.remote.core.Status
import com.vividseats.android.challenge.two.data.repository.HomeCardRepository
import com.vividseats.android.challenge.two.ui.core.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(
    application: Application,
    private val homeCardRepository: HomeCardRepository) : BaseViewModel(application) {

    val presentationData = MutableLiveData<Presentation>()

    fun bind() {
        //this is to ensure only one stream is active at a time
        compositeDisposable.clear()

        homeCardRepository.getHomeCards()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { resource ->
//                println(resource)
//                when(resource.status) {
//                    Status.LOADING -> null
//                    Status.SUCCESS -> {
//                        presentationData.postValue(Presentation(getApplication(), resource.data))
//                    }
//                }

//            }.addTo(compositeDisposable)
    }

    data class Presentation(private val context: Context,
                            private val homeCards: List<HomeCard>?) {

    }
}