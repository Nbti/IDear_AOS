package com.footstep.dangbal.kotlin.src.main.map

import com.footstep.dangbal.kotlin.src.main.map.model.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitInterface {

    @GET("/footstep/all")
    suspend fun getMapFootStepList() : AllResponse

    @GET("/footstep/{place-id}")
    suspend fun getMapFootStepPopup(@Path("place-id") place_id : Int) : PopupResponse

    @GET("/footstep/specific/{start-date}/{end-date}")
    suspend fun getMapFootStepSpecific(@Path("start-date") start_date : String, @Path("end-date") end_date:String) : SpecificFstResponse

    @GET("/footstep/city/{city-name}")
    suspend fun getMapFootStepCity(@Path("city-name")city: String) : CityResponse

    @GET("users/{user}")
    fun getUser(@Path("user") username: String): Call<User>

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
