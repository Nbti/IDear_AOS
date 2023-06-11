package com.nbit.Idear.mypage.moodKeywordAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ItemMoodKeywordProfileBinding
import com.nbit.Idear.databinding.ItemProfileListBinding
import com.nbit.Idear.mypage.profileAdapter.ProfileListAdapter
import com.nbit.Idear.mypage.profileAdapter.ProfileListItem

class MoodKeywordAdapter (
    private val context: Context,
    private val selectMoodKeyword: (keyWord: String) -> Unit
) :
    RecyclerView.Adapter<MoodKeywordAdapter.MoodKeywordViewHolder>(){

    var items = mutableListOf<MoodKeywordItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            MoodKeywordAdapter.MoodKeywordViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_mood_keyword_profile, parent, false)

        return MoodKeywordViewHolder(ItemMoodKeywordProfileBinding.bind(view))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoodKeywordAdapter.MoodKeywordViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {
            items[position].isSelected = true
            allUncheck(position)

            selectMoodKeyword(items[position].moodKeyword)
        }
    }

    inner class MoodKeywordViewHolder(private val binding: ItemMoodKeywordProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MoodKeywordItem) {
            binding.textMoodKeyword.text = item.moodKeyword

            if(item.isSelected) {
                binding.linearMoodKeyword.setBackgroundResource(R.drawable.shape_mood_profile_green)
            }
            else {
                binding.linearMoodKeyword.setBackgroundResource(R.drawable.shape_mood_profile_gray)
            }
        }
    }

    fun allUncheck(position: Int) {
        for(i in 0..(items.size - 1)) {
            if(i != position) {
                items[i].isSelected = false
            }
        }
        notifyDataSetChanged()
    }
}