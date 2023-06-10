package com.nbit.Idear.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityMyPageBinding

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