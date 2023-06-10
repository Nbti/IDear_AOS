package com.nbit.Idear.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ItemStarBinding
import com.nbit.Idear.databinding.ItemWriteBinding

class StarAdapter (private val dataList:ArrayList<StarData>):
    RecyclerView.Adapter<StarAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemStarBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        // var chk=false;
        fun bind(data: StarData) {
            viewBinding.yearText.text = data.year.toString()
            viewBinding.monthText.text = data.month.toString()
            viewBinding.dayText.text = data.day.toString()

            viewBinding.mainContent.text = data.content

            viewBinding.subCardView.setOnClickListener {

            }

        } }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarAdapter.DataViewHolder {
        val binding = ItemStarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}