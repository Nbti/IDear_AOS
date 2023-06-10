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
    private val context: Context
) :
    RecyclerView.Adapter<MoodKeywordAdapter.MoodKeywordViewHolder>(){

    var items = mutableListOf<ProfileListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            MoodKeywordAdapter.MoodKeywordViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_mood_keyword_profile, parent, false)

        return MoodKeywordViewHolder(ItemMoodKeywordProfileBinding.bind(view))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoodKeywordAdapter.MoodKeywordViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MoodKeywordViewHolder(private val binding: ItemMoodKeywordProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProfileListItem) {

        }
    }
}