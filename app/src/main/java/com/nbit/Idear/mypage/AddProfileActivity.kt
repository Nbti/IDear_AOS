package com.nbit.Idear.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityAddProfileBinding
import com.nbit.Idear.mypage.mbtiAdapter.MbtiAdapter
import com.nbit.Idear.mypage.mbtiAdapter.MbtiItem
import com.nbit.Idear.mypage.moodKeywordAdapter.MoodKeywordAdapter
import com.nbit.Idear.mypage.moodKeywordAdapter.MoodKeywordItem

// 프로필 추가 정보
class AddProfileActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityAddProfileBinding

    // 분위기 카테고리 recycler
    private lateinit var moodKeywordItems: MutableList<MoodKeywordItem>
    private lateinit var moodKeywordAdapter: MoodKeywordAdapter

    // mbti recycler
    private lateinit var mbtiItems: MutableList<MbtiItem>
    private lateinit var mbtiAdapter: MbtiAdapter

    // 내용 입력 완료
    private var selectKeyword: Boolean = false
    private var selectFormal: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setting
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recyclerview 세팅
        initRecycler()

        moodKeywordItems = mutableListOf<MoodKeywordItem>(MoodKeywordItem("깔끔한"), MoodKeywordItem("다정한"),
            MoodKeywordItem("냉철한"), MoodKeywordItem("귀여운"), MoodKeywordItem("친근한"), MoodKeywordItem("발랄한"),
            MoodKeywordItem("세련된"), MoodKeywordItem("공손한"), MoodKeywordItem("세심한"), MoodKeywordItem("기타"))
        moodKeywordAdapter.items = moodKeywordItems
        moodKeywordAdapter.notifyDataSetChanged()

        // 존댓말 선택
        binding.linearFormalTop.setOnClickListener(View.OnClickListener {
            binding.linearFormalLow.setBackgroundResource(R.drawable.shape_unselect_formal)
            binding.textFormalLow.setTextColor(getColor(R.color.idear_gray_800))

            binding.linearFormalTop.setBackgroundResource(R.drawable.shape_select_formal)
            binding.textFormalTop.setTextColor(getColor(R.color.white))

            selectFormal = true
            checkAllInput()
        })

        // 반말 선택
        binding.linearFormalLow.setOnClickListener(View.OnClickListener {
            binding.linearFormalTop.setBackgroundResource(R.drawable.shape_unselect_formal)
            binding.textFormalTop.setTextColor(getColor(R.color.idear_gray_800))

            binding.linearFormalLow.setBackgroundResource(R.drawable.shape_select_formal)
            binding.textFormalLow.setTextColor(getColor(R.color.white))

            selectFormal = true
            checkAllInput()
        })

        addMbti(MbtiItem("E", "I", true))
        addMbti(MbtiItem("N", "S", true))
        addMbti(MbtiItem("F", "T", true))
        addMbti(MbtiItem("P", "J", true))

        // 추가하기 버튼
        binding.btnAddProfileDone.setOnClickListener {
            if(selectFormal && selectKeyword) {
                finish()
            }
        }
    }

    // recyclerview 세팅
    private fun initRecycler() {
        moodKeywordItems = mutableListOf<MoodKeywordItem>()
        moodKeywordAdapter = MoodKeywordAdapter(
            this,
            selectMoodKeyword = {
                selectMoodKeyword()
            }
        )
        binding.recyclerMoodKeyword.layoutManager = GridLayoutManager(this, 5)
        binding.recyclerMoodKeyword.adapter = moodKeywordAdapter
        binding.recyclerMoodKeyword.isNestedScrollingEnabled = false
        moodKeywordAdapter.items = moodKeywordItems

        mbtiItems = mutableListOf<MbtiItem>()
        mbtiAdapter = MbtiAdapter(
            this
        )
        binding.recyclerToggleMbti.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerToggleMbti.adapter = mbtiAdapter
        binding.recyclerToggleMbti.isNestedScrollingEnabled = false
        mbtiAdapter.items = mbtiItems
    }

    private fun addMoodKeyword(item: MoodKeywordItem) {
        moodKeywordItems.apply {
            add(item)
        }
        moodKeywordAdapter.notifyDataSetChanged()
    }

    private fun addMbti(item: MbtiItem) {
        mbtiItems.apply {
            add(item)
        }
        mbtiAdapter.notifyDataSetChanged()
    }

    private fun checkAllInput() {
        if(selectFormal && selectKeyword) {
            binding.btnAddProfileDone.setBackgroundColor(getColor(R.color.idear_green))
            binding.btnAddProfileDone.setTextColor(getColor(R.color.white))
        }
    }

    private fun selectMoodKeyword() {
        selectKeyword = true
        checkAllInput()
    }
}