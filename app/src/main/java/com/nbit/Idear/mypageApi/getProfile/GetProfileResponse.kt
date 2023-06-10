package com.nbit.Idear.mypageApi.getProfile

import com.google.gson.annotations.SerializedName

data class GetProfileResponse(
    @SerializedName("httpStatusCode")
    val httpStatusCode: Int,

    @SerializedName("httpReasonPhrase")
    val httpReasonPhrase: String,

    @SerializedName("message")
    val message: String,

    @SerializedName("result")
    val result: MutableList<ProfileResult>,
)

data class ProfileResult(
    @SerializedName("id")
    val id: Int,

    @SerializedName("is_polite")
    val is_polite: Boolean,

    @SerializedName("mbti")
    val mbti: String,

    @SerializedName("profileKeyword")
    val profileKeyword: String,

    @SerializedName("user")
    val user: ProfileUser,
)

data class ProfileUser(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,
)