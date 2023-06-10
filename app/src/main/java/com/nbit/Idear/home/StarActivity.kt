package com.nbit.Idear.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityStarBinding

class StarActivity : AppCompatActivity() {

    lateinit var binding:ActivityStarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityStarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataDataList:ArrayList<StarData> = arrayListOf()

        dataDataList.apply{
            add(StarData(2023,6,23,"dfjslkdfjlksdjfkl"))
            add(StarData(2023,6,23,"dfjslkdfjlksdjfkl"))
            add(StarData(2023,6,23,"dfjslkdfjlksdjfkl"))

        }

        binding.leftArrowBtn.setOnClickListener {
            finish()
        }

        binding.starRecyclerView.layoutManager= LinearLayoutManager(this)
        val adapter=StarAdapter(dataDataList)
        binding.starRecyclerView.adapter=adapter
    }
}