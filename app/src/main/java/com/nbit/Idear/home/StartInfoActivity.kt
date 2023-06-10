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
/*
        val extras=intent.extras

        val yearData=extras!!.getInt("result1")
        val monthData=extras!!.getInt("result2")
        val dayData=extras!!.getInt("result3")
        val contentData=extras!!.getString("result4")

        binding.yearText.text=yearData.toString()
        binding.monthText.text=monthData.toString()
        binding.dayText.text=dayData.toString()

        binding.tvAiText.text=contentData.toString()

 */

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