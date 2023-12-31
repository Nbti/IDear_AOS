package com.nbit.Idear.mypage.profileAdapter

import android.graphics.Color

// 프로필 리스트 아이템
data class ProfileListItem(
    val profileId: Int,
    val moodKeyword: String, // 분위기 키워드
    var mbti: String?,        // 엠비티아이
    val formal: String,      // 반말, 존댓말
    val bgColor: Int,     // 프로필 원 배경 색상
    val isNew: Boolean,      // 새로운 프로필인지
)
