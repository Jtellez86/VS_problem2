package com.vividseats.android.challenge.two.data.repository

import com.vividseats.android.challenge.two.HomeCardRequest
import com.vividseats.android.challenge.two.data.local.model.HomeCard
import com.vividseats.android.challenge.two.data.remote.api.HomeCardsAPI
import com.vividseats.android.challenge.two.data.remote.core.Resource
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.addTo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeCardRepository(private val remoteApi: HomeCardsAPI) {

    //    fun getHomeCards() : Observable<Resource<List<HomeCard>>> {
//        return Observable.create<Resource<List<HomeCard>>> {emitter ->
//            remoteApi.getHomeCards(HomeCardRequest()).enqueue(object : Callback<List<HomeCard>>{
//                override fun onResponse(call: Call<List<HomeCard>>, response: Response<List<HomeCard>>) {
//                    response.body()?.let {responseBody ->
//                        emitter.onNext(Resource.Success(responseBody))
//                    }
//                }
//                override fun onFailure(call: Call<List<HomeCard>>, t: Throwable) {
//                    println("wtf $t")
//                }
//            })
//        }
//    }
    fun getHomeCards(){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl("https://webservices.vividseats.com/rest/mobile/v1/")
            .build()

        val homeCardsAPI = retrofit.create(HomeCardsAPI::class.java)

        homeCardsAPI.getHomeCards(HomeCardRequest()).enqueue(object : Callback<List<HomeCard>> {
            override fun onResponse(call: Call<List<HomeCard>>, response: Response<List<HomeCard>>) {
                println(response.body())
            }

            override fun onFailure(call: Call<List<HomeCard>>, t: Throwable) {
                println("wtf $t")
            }
        })
    }
}