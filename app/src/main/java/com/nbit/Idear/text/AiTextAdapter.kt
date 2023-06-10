package com.nbit.Idear.text

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R

class AiTextAdapter(private val buttonClickListener: (String, Int) -> Unit): RecyclerView.Adapter<AiTextAdapter.ViewHolder>() {

    private val items: MutableList<AiTextResult> = mutableListOf()

    fun addItem(item: AiTextResult) {
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AiTextAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_write_example, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AiTextAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView1: TextView = itemView.findViewById(R.id.tv_ai_text)
        private val favBtn: ImageFilterButton = itemView.findViewById(R.id.btn_favorite)
        private val shareBtn: ImageFilterButton = itemView.findViewById(R.id.btn_share)
        private val completeBtn: Button = itemView.findViewById(R.id.btn_complete)

        fun bind(item: AiTextResult) {
            textView1.text = item.content
            favBtn.isSelected = item.favorite

            shareBtn.setOnClickListener {
                buttonClickListener.invoke(textView1.text.toString(), 1)
            }
            favBtn.setOnClickListener {
                buttonClickListener.invoke(item.content, 0)
                favBtn.isSelected = !favBtn.isSelected
            }
            completeBtn.setOnClickListener {
                buttonClickListener.invoke(item.content, 2)
            }
        }
    }
}

data class AiTextResult(val content: String, val favorite: Boolean)