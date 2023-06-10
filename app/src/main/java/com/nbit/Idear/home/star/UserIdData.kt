package com.nbit.Idear.home.star

import com.google.gson.annotations.SerializedName

data class UserIdData(
    @SerializedName("id") val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("email")val email:String,
    @SerializedName("password")val password:String
)
