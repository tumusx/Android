package com.github.tumusx.core_network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val baseUrl = "https://private-anon-555c795552-maximatech.apiary-mock.com/android/"
    val retrofitInstance = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()
}