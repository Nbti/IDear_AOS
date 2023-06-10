package com.nbit.Idear.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityAddProfileBinding
import com.nbit.Idear.databinding.ActivityMyPageBinding

// 프로필 추가 정보
class AddProfileActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityAddProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setting
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}