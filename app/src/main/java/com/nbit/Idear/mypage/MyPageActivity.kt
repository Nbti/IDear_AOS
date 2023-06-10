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

// 마이 페이지: 프로필 리스트
class MyPageActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var binding: ActivityMyPageBinding

    // 프로필 recycler
    private lateinit var profileListItems: MutableList<ProfileListItem>
    private lateinit var profileListAdapter: ProfileListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setting
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recyclerview 세팅
        initRecycler()

        // 샘플 데이터
        addMoveFolderItem(ProfileListItem(0, "귀여운", "ESFP", "반말", ContextCompat.getColor(this, R.color.profile_yello), true))
        addMoveFolderItem(ProfileListItem(0, "귀여운", "ESFP", "반말", ContextCompat.getColor(this, R.color.profile_yello), false))
        addMoveFolderItem(ProfileListItem(0, "귀여운", "ESFP", "반말", ContextCompat.getColor(this, R.color.profile_yello), false))

        // 이전 버튼
        binding.btnBack.setOnClickListener {
            finish()
        }

        // 프로필 추가 버튼
        binding.linearAddProfile.setOnClickListener ( View.OnClickListener {
            // 프로필 추가 페이지
            val intent = Intent(this, AddProfileActivity::class.java)
            startActivity(intent)
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
    private fun addMoveFolderItem(item: ProfileListItem) {
        profileListItems.apply {
            add(item)
        }
        profileListAdapter.notifyDataSetChanged()
    }

    // 수정 페이지 이동
    fun moveToEditPage(profileNum: Int) {
        Log.d("Click Edit", "프로필 수정------------------")
    }
}