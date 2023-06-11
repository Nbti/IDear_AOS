package com.nbit.Idear.home

import com.google.gson.annotations.SerializedName
import com.nbit.Idear.home.first.GetRecordData
import com.nbit.Idear.home.star.StarNetData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/mypage/content/starred/{userId}")
    fun getStar(@Path("userId") userId: Int): Call<StarNetData>

    //home/query/content/{contentId}
    @GET("/app/home/query/content")
    fun getSpecificRecord(@Query("userId") userId: Int): Call<GetRecordData>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://54.180.95.50:9010")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
