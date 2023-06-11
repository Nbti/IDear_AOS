package com.nbit.Idear.mypageApi.addProfile

import com.google.gson.annotations.SerializedName

data class AddProfileRequest(
    @SerializedName("is_polite")
    val is_polite: Boolean,

    @SerializedName("mbti")
    val mbti: String?,

    @SerializedName("profileKeyword")
    val profileKeyword: String,
)
