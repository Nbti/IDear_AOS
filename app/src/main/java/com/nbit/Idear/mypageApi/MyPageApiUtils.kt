package com.nbit.Idear.mypageApi

import android.content.ContentValues.TAG
import android.util.Log
import com.nbit.Idear.RetrofitBuilder
import com.nbit.Idear.mypageApi.addProfile.AddProfileRequest
import com.nbit.Idear.mypageApi.addProfile.AddProfileService
import com.nbit.Idear.mypageApi.editProfile.EditProfileService
import com.nbit.Idear.mypageApi.getProfile.GetProfileResponse
import com.nbit.Idear.mypageApi.getProfile.GetProfileService
import com.nbit.Idear.mypageApi.getProfile.ProfileResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

// api 통신을 위한 retrofit
private val retrofit: Retrofit = MyPageClient.retrofit

fun apiGetProfile(
    getAllProfile: (items: MutableList<ProfileResult>) -> Unit
) {
    retrofit.create(GetProfileService::class.java)
        .getlProfile()
        .enqueue(object : Callback<GetProfileResponse> {
            override fun onResponse(call: Call<GetProfileResponse>, response: Response<GetProfileResponse>) {
                Log.d(TAG, "프로필 조회 결과 -------------------------------------------")
                Log.d(TAG, "onResponse: ${response.body().toString()}")

                val body: GetProfileResponse = response.body()!!
                val result: MutableList<ProfileResult> = body.result

                getAllProfile(result)
            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                Log.d(TAG, "프로필 조회 결과 fail -------------------------------------------")
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
}

fun apiAddProfile(
    profile: AddProfileRequest,
    finishAdd: () -> Unit
) {
    retrofit.create(AddProfileService::class.java)
        .addProfile(profile)
        .enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d(TAG, "프로필 추가 결과 -------------------------------------------")
                Log.d(TAG, "onResponse: ${response.body().toString()}")

                finishAdd()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d(TAG, "프로필 추가 결과 fail -------------------------------------------")
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
}

fun apiEditProfile(
    profileId: Int,
    profile: AddProfileRequest,
    finishAdd: () -> Unit
) {
    retrofit.create(EditProfileService::class.java)
        .editProfile(profile, profileId)
        .enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d(TAG, "프로필 수정 결과 -------------------------------------------")
                Log.d(TAG, "onResponse: ${response.body().toString()}")

                finishAdd()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d(TAG, "프로필 수정 결과 fail -------------------------------------------")
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
}