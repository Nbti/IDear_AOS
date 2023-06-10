package com.nbit.Idear.home.star

import com.google.gson.annotations.SerializedName

data class StarNetData(
    @SerializedName("httpStatusCode") val httpStatusCode: Int = 0,
    @SerializedName("httpReasonPhrase") val httpReasonPhrase: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("result") val result: ArrayList<ResultSpecific>

)
