package com.nbit.Idear.mypageApi.getProfile

import retrofit2.Call
import retrofit2.http.GET

interface GetProfileService {
    @GET("/mypage/profile")
    fun getlProfile(
    ): Call<GetProfileResponse>
}