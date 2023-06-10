package com.nbit.Idear.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityMyPageBinding
import com.nbit.Idear.mypage.profileAdapter.ProfileListAdapter
import com.nbit.Idear.mypage.profileAdapter.ProfileListItem
import com.nbit.Idear.mypageApi.apiGetProfile
import com.nbit.Idear.mypageApi.getProfile.ProfileResult

// 마이 페이지: 프로필 리스트
class MyPageActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityMyPageBinding

    // 프로필 recycler
    private lateinit var profileListItems: MutableList<ProfileListItem>
    private lateinit var profileListAdapter: ProfileListAdapter

    // 프로필 데이터
    private var allProfile: MutableList<ProfileResult>? = null

    private var bgColors = mutableListOf<String>("purple", "yellow", "blue")

    private var itemCount = -1

    override fun onResume() {
        super.onResume()

        // recyclerview 세팅
        initRecycler()

        // 프로필 조회
        apiGetProfile(
            getAllProfile = {
                getAllProfile(it)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setting
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이전 버튼
        binding.btnBack.setOnClickListener {
            finish()
        }

        // 프로필 추가 버튼
        binding.linearAddProfile.setOnClickListener ( View.OnClickListener {
            if(profileListItems.size < 10) {
                // 프로필 추가 페이지
                val intent = Intent(this, AddProfileActivity::class.java)
                intent.putExtra("mode", "add")
                startActivity(intent)
            }
        })

    }

    // recyclerview 세팅
    private fun initRecycler() {
        profileListItems = mutableListOf<ProfileListItem>()
        profileListAdapter = ProfileListAdapter(
            this,
            onClickEditButton = {
                moveToEditPage(it)
            }
        )
        binding.recyclerProfileList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerProfileList.adapter = profileListAdapter
        binding.recyclerProfileList.isNestedScrollingEnabled = false
        profileListAdapter.items = profileListItems
    }

    // 프로필 아이템 추가
    private fun addProfileItem(item: ProfileListItem) {
        profileListItems.apply {
            add(item)
        }
        profileListAdapter.notifyDataSetChanged()

        binding.textProfileListCount.text = profileListItems.size.toString()
    }

    // 수정 페이지 이동
    fun moveToEditPage(index: MutableList<Int>) {
        val intent = Intent(this, AddProfileActivity::class.java)
        intent.putExtra("mode", "edit")
        intent.putExtra("profileId", index[0])
        intent.putExtra("is_polite", allProfile!![index[1]].is_polite)
        intent.putExtra("mbti", allProfile!![index[1]].mbti)
        intent.putExtra("profileKeyword", allProfile!![index[1]].profileKeyword)
        startActivity(intent)
    }

    fun getAllProfile(items: MutableList<ProfileResult>) {
        allProfile = items

        var checkNew: Boolean = false

        if(itemCount != -1 && itemCount < items.size) {
            checkNew = true
        }
        itemCount = items.size

        for(i in 0..(items.size - 2)) {
            var formal: String = "반말"
            if(items[i].is_polite) formal = "존댓말"
            addProfileItem(
                ProfileListItem(
                    items[i].id,
                    items[i].profileKeyword,
                    items[i].mbti,
                    formal,
                    (i % 16) + 1,
                    false
                )
            )
        }

        var formal: String = "반말"
        if(items[items.size - 1].is_polite) formal = "존댓말"
        addProfileItem(
            ProfileListItem(
                items[items.size - 1].id,
                items[items.size - 1].profileKeyword,
                items[items.size - 1].mbti,
                formal,
                (items.size - 1 % 4) + 1,
                checkNew
            )
        )
    }
}