package com.example.mvvmdagger.di

import com.example.mvvmdagger.retrofit.APIInterface
import com.example.mvvmdagger.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getAPIInterface(retrofit: Retrofit): APIInterface {
        return retrofit.create(APIInterface::class.java)
    }
}