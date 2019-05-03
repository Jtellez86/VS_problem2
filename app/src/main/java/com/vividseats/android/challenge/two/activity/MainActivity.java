package com.vividseats.android.challenge.two.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vividseats.android.challenge.two.HomeCardRequest;
import com.vividseats.android.challenge.two.HomeCardsAPI;
import com.vividseats.android.challenge.two.R;
import com.vividseats.android.challenge.two.data.HomeCard;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .baseUrl("https://webservices.vividseats.com/rest/mobile/v1/")
                .build();
        HomeCardsAPI homeCardsAPI = retrofit.create(HomeCardsAPI.class);



        //goes to repo class
        homeCardsAPI.getHomeCards(new HomeCardRequest()).enqueue(new Callback<List<HomeCard>>() {
            @Override
            public void onResponse(Call<List<HomeCard>> call, Response<List<HomeCard>> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<HomeCard>> call, Throwable t) {

            }
        });
    }
}