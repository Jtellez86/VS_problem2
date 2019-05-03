package com.vividseats.android.challenge.two;

import com.vividseats.android.challenge.two.data.HomeCard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HomeCardsAPI {

    @POST("home/cards")
    Call<List<HomeCard>> getHomeCards(@Body HomeCardRequest homeCardRequest);
}
