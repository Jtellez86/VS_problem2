package com.vividseats.android.challenge.two.data.repository

import com.vividseats.android.challenge.two.HomeCardRequest
import com.vividseats.android.challenge.two.data.local.model.HomeCard
import com.vividseats.android.challenge.two.data.remote.api.HomeCardsAPI
import com.vividseats.android.challenge.two.data.remote.core.Resource
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeCardRepository(private val remoteApi: HomeCardsAPI) {

    fun getHomeCards(): Observable<Resource<List<HomeCard>>> {
        return Observable.create<Resource<List<HomeCard>>> { emitter ->
            remoteApi.getHomeCards(HomeCardRequest()).enqueue(object : Callback<List<HomeCard>> {
                override fun onResponse(call: Call<List<HomeCard>>, response: Response<List<HomeCard>>) {
                    response.body()?.let { responseBody ->
                        emitter.onNext(Resource.Success(responseBody))
                    }
                }

                override fun onFailure(call: Call<List<HomeCard>>, t: Throwable) {
                    emitter.onError(Exception(t))
                }
            })
        }
    }
}