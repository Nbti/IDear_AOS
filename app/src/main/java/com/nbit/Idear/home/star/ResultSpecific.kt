package com.nbit.Idear.home.star

import com.google.gson.annotations.SerializedName

data class ResultSpecific(
    @SerializedName("starId") val starId:Int,
    @SerializedName("content")val content:String,
    @SerializedName("regdate")val regdate:ArrayList<Int>,
    @SerializedName("userId")val userId: UserIdData
)
