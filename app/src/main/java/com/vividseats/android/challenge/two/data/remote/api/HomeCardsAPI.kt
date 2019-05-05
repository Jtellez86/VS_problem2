package com.vividseats.android.challenge.two.data.remote.api

import com.vividseats.android.challenge.two.HomeCardRequest
import com.vividseats.android.challenge.two.data.local.model.HomeCard

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeCardsAPI {

    @POST("home/cards")
    fun getHomeCards(@Body homeCardRequest: HomeCardRequest): Call<List<HomeCard>>
}
