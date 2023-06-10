package com.nbit.Idear.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityMyPageBinding

// 마이 페이지: 프로필 리스트
class MyPageActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setting
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}