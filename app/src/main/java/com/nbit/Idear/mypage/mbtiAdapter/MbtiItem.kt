package com.nbit.Idear.mypage.mbtiAdapter

data class MbtiItem (
    val topMbti: String,
    val bottomMbti: String,
    var isSelectTop: Boolean,
    var unselect: Boolean = true,
)