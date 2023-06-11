package com.nbit.Idear.mypageApi.addProfile

import com.nbit.Idear.mypageApi.getProfile.GetProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// 프로필 생성
interface AddProfileService {
    @POST("/mypage/profile")
    fun addProfile(
        @Body params: AddProfileRequest
    ): Call<String>
}