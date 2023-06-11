package com.nbit.Idear.mypageApi.editProfile

import com.nbit.Idear.mypageApi.addProfile.AddProfileRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface EditProfileService {
    @PATCH("/mypage/profile/{profileId}")
    fun editProfile(
        @Body params: AddProfileRequest,
        @Path("profileId") profileId: Int
    ): Call<String>
}