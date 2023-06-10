package com.nbit.Idear.mypage.profileAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ItemProfileListBinding

// 프로필 리스트 어댑터
class ProfileListAdapter (
    private val context: Context,
    val onClickEditButton: (profileNum: Int) -> Unit
    ) :
    RecyclerView.Adapter<ProfileListAdapter.ProfileListViewHolder>(){

    var items = mutableListOf<ProfileListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            ProfileListViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_profile_list, parent, false)

        return ProfileListViewHolder(ItemProfileListBinding.bind(view))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProfileListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ProfileListViewHolder(private val binding: ItemProfileListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProfileListItem) {
            binding.profileIcon.textMoodKeywordForIcon.text = item.moodKeyword
            binding.profileIcon.textMbtiForIcon.text = item.mbti

            binding.textMbtiForInfo.text = item.mbti + "/"
            binding.textFormalForInfo.text = item.formal

            // 프로필 원형 배경색
            //binding.profileIcon.linearProfileIcon.setBackgroundColor(item.bgColor)

            // 수정하기 버튼
            binding.btnEditProfile.setOnClickListener {
                onClickEditButton(item.profileNum)
            }
        }
    }
}