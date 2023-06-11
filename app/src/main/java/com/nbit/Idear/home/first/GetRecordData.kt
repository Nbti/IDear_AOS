package com.nbit.Idear.home.first

import com.google.gson.annotations.SerializedName
import com.nbit.Idear.home.star.ResultSpecific

data class GetRecordData(
    @SerializedName("httpStatusCode") val httpStatusCode: Int = 0,
    @SerializedName("httpReasonPhrase") val httpReasonPhrase: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("result") val result: ArrayList<ResultRecordSpecific>


)
