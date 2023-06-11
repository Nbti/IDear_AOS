package com.nbit.Idear.home.first

import com.google.gson.annotations.SerializedName

data class ResultRecordSpecific(
    @SerializedName("dear") val dear: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("createAt") val createAt: String? = null,
    @SerializedName("contentResList") val contentReslist: ArrayList<ContentSpecific>
)
