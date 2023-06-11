package com.nbit.Idear.home.first

import com.google.gson.annotations.SerializedName

data class ContentSpecific(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("content") val content: String? = null,
    @SerializedName("feedback") val feedback: String? = null,
    @SerializedName("createAt") val createdAt: String?=null
)
