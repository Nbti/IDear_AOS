package com.nbit.Idear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.databinding.ActivityMainBinding
import com.nbit.Idear.databinding.MainIncludeDrawerBinding
import com.nbit.Idear.home.ProxyWriteAdapter
import com.nbit.Idear.home.ProxyWriteData
import com.nbit.Idear.home.WriteSubData
import com.nbit.Idear.mypage.MyPageActivity
import com.nbit.Idear.write.WriteActivity

// 메인 페이지
class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var drawerBinding: MainIncludeDrawerBinding // 메뉴 Drawer
    lateinit var mainBinding: ActivityMainBinding        // 메인 페이지
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 메뉴 Drawer ViewBinding
        drawerBinding = MainIncludeDrawerBinding.inflate(layoutInflater)
        setContentView(drawerBinding.root)

        // 메인 페이지 viewBinding
        mainBinding = drawerBinding.includeMainActivity

        // 메뉴 열기 버튼 누르면 열림
        mainBinding.btnOpenMenu.setOnClickListener {
            drawerBinding.mainDrawerLayout.openDrawer((GravityCompat.END))
        }

        // 마이페이지 메뉴 버튼 선택
        drawerBinding.btnMenuMypage.setOnClickListener {
            // 마이페이지 이동
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }

        // 즐겨찾기 메뉴 버튼 선택
        drawerBinding.btnMenuBookmark.setOnClickListener {
            // 즐겨찾기 목록 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }

        // 환경설정 메뉴 버튼 선택
        drawerBinding.btnMenuSetting.setOnClickListener {
            // 환경설정 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }

        // 로그인/로그아웃 메뉴 버튼 선택
        drawerBinding.btnMenuLoginLogout.setOnClickListener {
            // 로그인/로그아웃 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }


       // mainBinding=ActivityMainBinding.inflate(layoutInflater)

        val dataDataList:ArrayList<ProxyWriteData> = arrayListOf()

        dataDataList.apply{
           /* add(ProxyWriteData(2023,6,12,"친구에게 전하는 생일 편지",
                "생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. " +
                        "너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 " +
                        "비춰줘서 고마워! 정말...",null))

            */
            add(ProxyWriteData(2023,6,12,"친구에게 전하는 생일 편지","생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 비춰줘...",
                arrayListOf(WriteSubData("너는 내게 있어서 특별한 존재야. 우리가 ..."),
                    WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."))))

            /*

             */
            add(ProxyWriteData(2023,6,12,"친구에게 전하는 생일 편지","생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 비춰줘...",
                arrayListOf(WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."),
                    WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."),
                    WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."))))

            add(ProxyWriteData(2023,6,12,"친구에게 전하는 생일 축하",
                "생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. " +
                        "너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 " +
                        "비춰줘서...",null))

        }

        mainBinding.mainRecyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=ProxyWriteAdapter(dataDataList)
        mainBinding.mainRecyclerView.adapter=adapter

        mainBinding.fab.setOnClickListener {

            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
    }
}