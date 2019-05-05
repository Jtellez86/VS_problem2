package com.vividseats.android.challenge.two.di.module

import com.vividseats.android.challenge.two.BuildConfig
import com.vividseats.android.challenge.two.data.remote.HttpConstants
import com.vividseats.android.challenge.two.data.remote.api.HomeCardsAPI
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class HttpModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient =
        okHttpClientBuilder.build()

    @Provides
    fun provideOkHttpClientBuilder(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(HttpConstants.TIMEOUT_IO, HttpConstants.TIMEOUT_TIME_UNIT)
            .readTimeout(HttpConstants.TIMEOUT_IO, HttpConstants.TIMEOUT_TIME_UNIT)
            .writeTimeout(HttpConstants.TIMEOUT_IO, HttpConstants.TIMEOUT_TIME_UNIT)
    }

    @Singleton
    @Provides
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder, httpClient: OkHttpClient): Retrofit =
        retrofitBuilder
            .client(httpClient)
            .build()

    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHomesCardApi(retrofit: Retrofit): HomeCardsAPI = retrofit.create(HomeCardsAPI::class.java)

}