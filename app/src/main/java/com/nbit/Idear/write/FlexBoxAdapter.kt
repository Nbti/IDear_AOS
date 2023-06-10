package com.nbit.Idear.write

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R

class FlexBoxAdapter(private val buttonTextList: List<String>, private val buttonClickListener: (String) -> Unit) : RecyclerView.Adapter<FlexBoxAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyword_btn, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val buttonText = buttonTextList[position]

        // 버튼 텍스트 설정
        holder.button.text = buttonText

        // 버튼 클릭 리스너 설정
        holder.button.setOnClickListener {
            buttonClickListener.invoke(buttonText)
        }
    }

    override fun getItemCount(): Int {
        return buttonTextList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: TextView = itemView.findViewById(R.id.button)
    }
}