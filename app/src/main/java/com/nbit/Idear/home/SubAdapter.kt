package com.nbit.Idear.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.databinding.ItemSubWriteBinding

class SubAdapter(private val dataList:ArrayList<WriteSubData>):
    RecyclerView.Adapter<SubAdapter.DataViewHolder>(){
    inner class DataViewHolder(private val viewBinding:ItemSubWriteBinding) :RecyclerView.ViewHolder(viewBinding.root){
        private val context = viewBinding.root.context

        fun bind(data:WriteSubData){
            viewBinding.subContentText.text=data.subContent

            viewBinding.rightBtn.setOnClickListener {
                val intent = Intent(context, WriteRecordInfoActivity::class.java)
                intent.run { context.startActivity(this) }
            }
            viewBinding.cardView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubAdapter.DataViewHolder {
        val viewBinding = ItemSubWriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}
