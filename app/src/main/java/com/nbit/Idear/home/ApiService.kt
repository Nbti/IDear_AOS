package com.nbit.Idear.home

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/mypage/content/starred/{userId}")
    fun getStar(@Path("userId") username: String): Call<Response>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.example.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
