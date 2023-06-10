package com.nbit.Idear.mypage

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityAddProfileBinding
import com.nbit.Idear.mypage.mbtiAdapter.MbtiAdapter
import com.nbit.Idear.mypage.mbtiAdapter.MbtiItem
import com.nbit.Idear.mypage.moodKeywordAdapter.MoodKeywordAdapter
import com.nbit.Idear.mypage.moodKeywordAdapter.MoodKeywordItem
import com.nbit.Idear.mypageApi.addProfile.AddProfileRequest
import com.nbit.Idear.mypageApi.apiAddProfile
import com.nbit.Idear.mypageApi.apiEditProfile

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
    private var selectMbti: Boolean = false

    private var profileId: Int? = null
    private var profileKeyword: String? = null
    private var isPolite: Boolean = false
    private var mbti: String? = null

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

        addMbti(MbtiItem("E", "I", true))
        addMbti(MbtiItem("N", "S", true))
        addMbti(MbtiItem("F", "T", true))
        addMbti(MbtiItem("P", "J", true))

        val mode = intent.getStringExtra("mode")
        // 수정 모드
        if(mode == "edit") {
            binding.btnAddProfileDone.setText(R.string.edit_profile_done)
            binding.textAddProfileLabel.setText(R.string.edit_profile_label)

            // 수정 모드에서는 무조건 수정 가능 = 모든 값이 입력되어 있으므로
            selectKeyword = true
            selectFormal = true
            selectMbti = true
            checkAllInput()

            // 변경 전 데이터
            profileId = intent.getIntExtra("profileId", -1)
            profileKeyword = intent.getStringExtra("profileKeyword")
            isPolite = intent.getBooleanExtra("isPolite", false)
            mbti = intent.getStringExtra("mbti")

            // 반말, 존댓말 변경 전 값으로 보여주기
            if(isPolite) {
                binding.linearFormalLow.setBackgroundResource(R.drawable.shape_unselect_formal)
                binding.textFormalLow.setTextColor(getColor(R.color.idear_gray_800))

                binding.linearFormalTop.setBackgroundResource(R.drawable.shape_select_formal)
                binding.textFormalTop.setTextColor(getColor(R.color.white))
            } else {
                binding.linearFormalTop.setBackgroundResource(R.drawable.shape_unselect_formal)
                binding.textFormalTop.setTextColor(getColor(R.color.idear_gray_800))

                binding.linearFormalLow.setBackgroundResource(R.drawable.shape_select_formal)
                binding.textFormalLow.setTextColor(getColor(R.color.white))
            }

            // 키워드 변경 전 값으로 보여주기
            for(i in 0..(moodKeywordItems.size - 1)) {
                if(moodKeywordItems[i].moodKeyword == profileKeyword) {
                    moodKeywordItems[i].isSelected = true
                    moodKeywordAdapter.notifyDataSetChanged()
                    break
                }
            }

            // MBTI 변경 전 값으로 보여주기
            for(i in 0..(mbtiItems.size - 1)) {
                if(mbtiItems[i].topMbti == mbti?.get(i).toString()) {
                    mbtiItems[i].isSelectTop = true
                }
                else if(mbtiItems[i].bottomMbti == mbti?.get(i).toString()) {
                    mbtiItems[i].isSelectTop = false
                }
                mbtiItems[i].unselect = false
            }
            mbtiAdapter.notifyDataSetChanged()
        }

        // 존댓말 선택
        binding.linearFormalTop.setOnClickListener(View.OnClickListener {
            binding.linearFormalLow.setBackgroundResource(R.drawable.shape_unselect_formal)
            binding.textFormalLow.setTextColor(getColor(R.color.idear_gray_800))

            binding.linearFormalTop.setBackgroundResource(R.drawable.shape_select_formal)
            binding.textFormalTop.setTextColor(getColor(R.color.white))

            selectFormal = true
            isPolite = true
            checkAllInput()
        })

        // 반말 선택
        binding.linearFormalLow.setOnClickListener(View.OnClickListener {
            binding.linearFormalTop.setBackgroundResource(R.drawable.shape_unselect_formal)
            binding.textFormalTop.setTextColor(getColor(R.color.idear_gray_800))

            binding.linearFormalLow.setBackgroundResource(R.drawable.shape_select_formal)
            binding.textFormalLow.setTextColor(getColor(R.color.white))

            selectFormal = true
            isPolite = false
            checkAllInput()
        })

        // 이전 버튼
        binding.btnBack.setOnClickListener {
            finish()
        }

        // 추가하기 버튼
        binding.btnAddProfileDone.setOnClickListener {
            if(selectFormal && selectKeyword && selectMbti) {
                // 추가
                if(mode == "add")
                    apiAddProfile(AddProfileRequest(isPolite, mbti, profileKeyword!!), finishAdd = {finish()})
                // 수정
                else
                    apiEditProfile(profileId!!, AddProfileRequest(isPolite, mbti, profileKeyword!!), finishAdd = {finish()})
            }
        }
    }

    // recyclerview 세팅
    private fun initRecycler() {
        moodKeywordItems = mutableListOf<MoodKeywordItem>()
        moodKeywordAdapter = MoodKeywordAdapter(
            this,
            selectMoodKeyword = {
                selectMoodKeyword(it)
            }
        )
        binding.recyclerMoodKeyword.layoutManager = GridLayoutManager(this, 5)
        binding.recyclerMoodKeyword.adapter = moodKeywordAdapter
        binding.recyclerMoodKeyword.isNestedScrollingEnabled = false
        moodKeywordAdapter.items = moodKeywordItems

        mbtiItems = mutableListOf<MbtiItem>()
        mbtiAdapter = MbtiAdapter(
            this,
            selectMbti = {
                selectMbti(it)
            }
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
        if(selectFormal && selectKeyword && selectMbti) {
            binding.btnAddProfileDone.setBackgroundColor(getColor(R.color.idear_green))
            binding.btnAddProfileDone.setTextColor(getColor(R.color.white))
        }
    }

    private fun selectMoodKeyword(keyword: String) {
        selectKeyword = true
        profileKeyword = keyword
        checkAllInput()
    }

    private fun selectMbti(item: String) {
        selectMbti = true
        mbti = item
        checkAllInput()
    }
}