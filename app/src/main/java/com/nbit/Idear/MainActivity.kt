package com.nbit.Idear

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.GravityCompat
import com.nbit.Idear.databinding.ActivityMainBinding
import com.nbit.Idear.databinding.MainIncludeDrawerBinding
import com.nbit.Idear.mypage.MyPageActivity

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

        //status bar와 navigation bar 모두 투명하게 만드는 코드
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        mainBinding.mainLayout.setPadding(0,getStatusBarHeight(this), 0, 0)

        // 메뉴 열기 버튼 누르면 열림
        mainBinding.btnOpenMenu.setOnClickListener{
            drawerBinding.mainDrawerLayout.openDrawer((GravityCompat.END))
        }

        // 마이페이지 메뉴 버튼 선택
        drawerBinding.btnMenuMypage.setOnClickListener(View.OnClickListener {
            // 마이페이지 이동
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        })

        // 즐겨찾기 메뉴 버튼 선택
        drawerBinding.btnMenuBookmark.setOnClickListener(View.OnClickListener {
            // 즐겨찾기 목록 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        })

        // 환경설정 메뉴 버튼 선택
        drawerBinding.btnMenuSetting.setOnClickListener(View.OnClickListener {
            // 환경설정 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        })

        // 로그인/로그아웃 메뉴 버튼 선택
        drawerBinding.btnMenuLogout.setOnClickListener(View.OnClickListener {
            // 로그인/로그아웃 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        })
    }

    fun getStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        return if (resourceId > 0) {
            context.resources.getDimensionPixelSize(resourceId)
        } else {
            0
        }
    }
}