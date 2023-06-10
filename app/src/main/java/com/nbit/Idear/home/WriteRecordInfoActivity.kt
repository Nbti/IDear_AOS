package com.nbit.Idear.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityStartInfoBinding
import com.nbit.Idear.databinding.ActivityWriteRecordInfoBinding

class WriteRecordInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityWriteRecordInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWriteRecordInfoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.leftArrowBtn.setOnClickListener {
            finish()
        }
    }
}

/*
   lateinit var binding:ActivityStartInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityStartInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.leftArrowBtn.setOnClickListener {
            finish()
        }
 */