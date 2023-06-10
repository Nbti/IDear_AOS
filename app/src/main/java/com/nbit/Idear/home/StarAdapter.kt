package com.nbit.Idear.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getMainExecutor
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ItemStarBinding
import com.nbit.Idear.databinding.ItemWriteBinding
import com.nbit.Idear.home.star.ResultSpecific
import com.nbit.Idear.write.WriteActivity

/*class StarAdapter (private val dataList:ArrayList<ResultSpecific>?):
    RecyclerView.Adapter<StarAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemStarBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        // var chk=false;
        private val context = viewBinding.root.context

        fun bind(data: ResultSpecific) {
         //   viewBinding.yearText.text = data.year.toString()
          //  viewBinding.monthText.text = data.month.toString()
           // viewBinding.dayText.text = data.day.toString()

           // viewBinding.mainContent.text = data.content

            viewBinding.yearText.text = data.regdate[0].toString()
            viewBinding.monthText.text = data.regdate[1].toString()
            viewBinding.dayText.text = data.regdate[2].toString()

            viewBinding.mainContent.text = data.content

            viewBinding.rightBtn.setOnClickListener {
                val intent = Intent(context, StartInfoActivity::class.java)
               // startActivity(intent)
                intent.putExtra("result1",data.regdate[0])
                intent.putExtra("result2",data.regdate[1])
                intent.putExtra("result3",data.regdate[2])
                intent.putExtra("result4",data.content)


                intent.run { context.startActivity(this) }

            }

        } }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarAdapter.DataViewHolder {
        val binding = ItemStarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList!!.get(position))
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }


}

 */

class StarAdapter (private val dataList:ArrayList<StarData>):
    RecyclerView.Adapter<StarAdapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemStarBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        // var chk=false;
        private val context = viewBinding.root.context

        fun bind(data: StarData) {
            viewBinding.yearText.text = data.year.toString()
            viewBinding.monthText.text = data.month.toString()
            viewBinding.dayText.text = data.day.toString()

             viewBinding.mainContent.text = data.content

            //viewBinding.yearText.text = data.regdate[0].toString()
            //viewBinding.monthText.text = data.regdate[1].toString()
            //viewBinding.dayText.text = data.regdate[2].toString()

            //viewBinding.mainContent.text = data.content

            viewBinding.rightBtn.setOnClickListener {
                val intent = Intent(context, StartInfoActivity::class.java)
                // startActivity(intent)
                //intent.putExtra("result1",data.regdate[0])
                //intent.putExtra("result2",data.regdate[1])
                //intent.putExtra("result3",data.regdate[2])
                //intent.putExtra("result4",data.content)


                intent.run { context.startActivity(this) }

            }

        } }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarAdapter.DataViewHolder {
        val binding = ItemStarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}