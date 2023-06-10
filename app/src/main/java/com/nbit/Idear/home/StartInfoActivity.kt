package com.nbit.Idear.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityStartInfoBinding

class StartInfoActivity : AppCompatActivity() {
    lateinit var binding:ActivityStartInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityStartInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.leftArrowBtn.setOnClickListener {
            finish()
        }
    }
}
/*
  lateinit var binding:ActivityStarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityStarBinding.inflate(layoutInflater)
        setContentView(binding.root)

 */