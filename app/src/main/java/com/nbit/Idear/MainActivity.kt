package com.nbit.Idear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.databinding.ActivityMainBinding
import com.nbit.Idear.databinding.MainIncludeDrawerBinding
import com.nbit.Idear.home.*
import com.nbit.Idear.home.first.GetRecordData
import com.nbit.Idear.home.star.StarNetData
import com.nbit.Idear.mypage.MyPageActivity
import com.nbit.Idear.write.WriteActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
            val intent = Intent(this, StarActivity::class.java)
            startActivity(intent)
            // 메뉴 닫기
            //drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }

        // 환경설정 메뉴 버튼 선택
        drawerBinding.btnMenuSetting.setOnClickListener {
            // 환경설정 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }

        // 로그인/로그아웃 메뉴 버튼 선택
        drawerBinding.btnMenuLogout.setOnClickListener {
            // 로그인/로그아웃 이동

            // 메뉴 닫기
            drawerBinding.mainDrawerLayout.closeDrawer((GravityCompat.END))
        }


        // mainBinding=ActivityMainBinding.inflate(layoutInflater)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://54.180.95.50:9010") // 서버의 baseUrl을 설정합니다.
            .addConverterFactory(GsonConverterFactory.create()) // JSON 데이터 변환을 위한 Gson 변환기를 추가합니다.
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        apiService.getSpecificRecord(1).enqueue(object : Callback<GetRecordData> {
            override fun onResponse(
                call: Call<GetRecordData>,
                response: retrofit2.Response<GetRecordData>
            ) {
                if (response.isSuccessful) {
                    val user = response.body()
                    //for(i in 0 until user?.result!!.size){
                    //    user.result[i].
                    //}

                    Log.d("서버값2",user!!.result[0].contentReslist[0].content.toString())

                    // 서버로부터 받은 데이터를 처리합니다.
                } else {
                    // 서버 응답이 실패한 경우 처리합니다.
                    Log.d("서버값2","성공-실패")

                }
            }

            override fun onFailure(call: Call<GetRecordData>, t: Throwable) {
                // 네트워크 오류 등 예외가 발생한 경우 처리합니다.
                Log.d("서버값2",t.toString())

            }


        })

        val dataDataList: ArrayList<ProxyWriteData> = arrayListOf()

        dataDataList.apply {
            /* add(ProxyWriteData(2023,6,12,"친구에게 전하는 생일 편지",
                 "생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. " +
                         "너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 " +
                         "비춰줘서 고마워! 정말...",null))


            */
            add(ProxyWriteData(R.drawable.profile_image4,2023,6,12,"친구에게 전하는 생일 편지","생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 비춰줘...",
                arrayListOf(WriteSubData("너는 내게 있어서 특별한 존재야. 우리가 ..."),
                    WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."))))


          /*
            add(
                ProxyWriteData(
                    2023,
                    6,
                    12,
                    "친구에게 전하는 생일 편지",
                    "생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 비춰줘...",
                    arrayListOf(
                        WriteSubData("너는 내게 있어서 특별한 존재야. 우리가 ..."),
                        WriteSubData("너는 내게 있어서 특별한 존재야. 우리가...")
                    )
                )
            )
*/

            /*

             */

            add(ProxyWriteData(R.drawable.profile_image5,2023,6,12,"친구에게 전하는 생일 편지","생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 비춰줘...",
                arrayListOf(WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."),
                    WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."),
                    WriteSubData("너는 내게 있어서 특별한 존재야. 우리가..."))))

            add(ProxyWriteData(R.drawable.profile_image6,2023,6,12,"친구에게 전하는 생일 축하",
                "생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. " +
                        "너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 언제나 우리 주위를 환하게 " +
                        "비춰줘서...",null))

        }

        mainBinding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProxyWriteAdapter(dataDataList)
        mainBinding.mainRecyclerView.adapter = adapter

        mainBinding.fab.setOnClickListener {

            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

    }
}

//val retrofit = Retrofit.Builder()
//   .baseUrl("https://api.example.com/") // 서버의 baseUrl을 설정합니다.
//   .addConverterFactory(GsonConverterFactory.create()) // JSON 데이터 변환을 위한 Gson 변환기를 추가합니다.
//   .build()

// val apiService = retrofit.create(RetrofitInterface::class.java)
// val apiService = RetrofitInterface.crea