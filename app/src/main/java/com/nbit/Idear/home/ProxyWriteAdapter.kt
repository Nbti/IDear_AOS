package com.nbit.Idear.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ItemWriteBinding

class ProxyWriteAdapter (private val dataList:ArrayList<ProxyWriteData>):
    RecyclerView.Adapter<ProxyWriteAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemWriteBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        // var chk=false;
        fun bind(data: ProxyWriteData) {
            viewBinding.yearText.text = data.year.toString()
            viewBinding.monthText.text = data.month.toString()
            viewBinding.dayText.text = data.day.toString()

            viewBinding.mainContent.text = data.content

            if (data.additionalContent.size != 0) {
                viewBinding.upBtn.setOnClickListener {
                    if (!viewBinding.upBtn.isSelected) {
                        viewBinding.upBtn.setImageResource(R.drawable.downbtn)
                        viewBinding.subCardView.visibility=View.VISIBLE
                        viewBinding.recyclerView.visibility = View.VISIBLE


                        viewBinding.recyclerView.apply {
                            setHasFixedSize(true)
                            layoutManager = LinearLayoutManager(viewBinding.root.context)
                            adapter = SubAdapter(data.additionalContent)
                        }
                        viewBinding.upBtn.isSelected = true
                    } else {
                        viewBinding.upBtn.setImageResource(R.drawable.upbtn)
                        viewBinding.subCardView.visibility=View.GONE
                        viewBinding.recyclerView.visibility = View.GONE

                        viewBinding.upBtn.isSelected = false
                    }

                }
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProxyWriteAdapter.DataViewHolder {
        val binding = ItemWriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}