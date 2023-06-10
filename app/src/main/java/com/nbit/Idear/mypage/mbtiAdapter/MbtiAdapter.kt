package com.nbit.Idear.mypage.mbtiAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ItemMoodKeywordProfileBinding
import com.nbit.Idear.databinding.ItemToggleMbtiBinding
import com.nbit.Idear.mypage.moodKeywordAdapter.MoodKeywordAdapter
import com.nbit.Idear.mypage.moodKeywordAdapter.MoodKeywordItem

// mbti 토글 어댑터
class MbtiAdapter (
    private val context: Context,
    val selectMbti: (mbti: String) -> Unit
) :
    RecyclerView.Adapter<MbtiAdapter.MbtiViewHolder>(){

    var items = mutableListOf<MbtiItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            MbtiAdapter.MbtiViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_toggle_mbti, parent, false)

        return MbtiViewHolder(ItemToggleMbtiBinding.bind(view))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MbtiAdapter.MbtiViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    inner class MbtiViewHolder(private val binding: ItemToggleMbtiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MbtiItem, position: Int) {
            binding.textMbtiTopSelect.text = item.topMbti
            binding.textMbtiTopUnselect.text = item.topMbti

            binding.textMbtiBottomSelect.text = item.bottomMbti
            binding.textMbtiBottomUnselect.text = item.bottomMbti

            // mbti 선택 안 됨
            if(item.unselect) {
                binding.textMbtiTopSelect.setBackgroundResource(R.drawable.shape_unselect_mbti)
                binding.textMbtiTopSelect.setTextColor(getColor(context, R.color.white))

                binding.textMbtiBottomSelect.visibility = View.GONE
            }
            // 위쪽 mbti 선택됨
            else if(item.isSelectTop) {
                binding.textMbtiTopSelect.setBackgroundResource(R.drawable.shape_select_mbti)
                binding.textMbtiTopSelect.setTextColor(getColor(context, R.color.white))

                binding.textMbtiTopSelect.visibility = View.VISIBLE
                binding.textMbtiBottomSelect.visibility = View.GONE
            }
            // 아래쪽 mbti 선택됨
            else {
                binding.textMbtiBottomSelect.setBackgroundResource(R.drawable.shape_select_mbti)
                binding.textMbtiBottomSelect.setTextColor(getColor(context, R.color.white))

                binding.textMbtiTopSelect.visibility = View.GONE
                binding.textMbtiBottomSelect.visibility = View.VISIBLE
            }

            binding.textMbtiTopSelect.setOnClickListener(View.OnClickListener {
                item.isSelectTop = false
                select(position)
            })

            binding.textMbtiBottomSelect.setOnClickListener(View.OnClickListener {
                item.isSelectTop = true
                select(position)
            })
        }
    }

    fun select(position: Int) {
        var mbtiResult: String = ""
        for(i in 0..(items.size - 1)) {
            items[i].unselect = false
            if(items[i].isSelectTop) {
                mbtiResult += items[i].topMbti
            }
            else {
                mbtiResult += items[i].bottomMbti
            }
        }

        selectMbti(mbtiResult)
        notifyDataSetChanged()
    }
}