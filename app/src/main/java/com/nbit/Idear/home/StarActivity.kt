package com.nbit.Idear.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbit.Idear.databinding.ActivityStarBinding
import com.nbit.Idear.home.star.ResultSpecific
import com.nbit.Idear.home.star.StarNetData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StarActivity : AppCompatActivity() {
    var userArr: ArrayList<ResultSpecific>? =null

    lateinit var binding:ActivityStarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityStarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataDataList:ArrayList<StarData> = arrayListOf()

        dataDataList.apply{
            add(StarData(2023,6,23,"생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 " +
                    "언제나 우리 주위를 환하게 비춰줘서 고마워! 정말..."))
            add(StarData(2023,6,23,"생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 친절한 마음으로 " +
                    "언제나 우리 주위를 환하게 비춰줘서 고마워! 정말..."))
            add(StarData(2023,6,23,"생일 축하해! 이 특별한 날을 기념하여 마음 가득한 축하의 말을 전하고 싶어요. 너의 생일은 항상 특별한 순간이야. 너의 유쾌한 에너지와 " +
                    "친절한 마음으로 언제나 우리 주위를 환하게 비춰줘서 고마워! 정말..."))
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("http://54.180.95.50:9010") // 서버의 baseUrl을 설정합니다.
            .addConverterFactory(GsonConverterFactory.create()) // JSON 데이터 변환을 위한 Gson 변환기를 추가합니다.
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        apiService.getStar("1").enqueue(object : Callback<StarNetData> {
            override fun onResponse(
                call: Call<StarNetData>,
                response: retrofit2.Response<StarNetData>
            ) {
                if (response.isSuccessful) {
                    val user = response.body()
                    //for(i in 0 until user?.result!!.size){
                    //    user.result[i].
                    //}
                    userArr=user?.result
                    Log.d("서버값",user?.result.toString())
                    // 서버로부터 받은 데이터를 처리합니다.
                } else {
                    // 서버 응답이 실패한 경우 처리합니다.
                    Log.d("서버값","성공-실패")

                }
            }

            override fun onFailure(call: Call<StarNetData>, t: Throwable) {
                // 네트워크 오류 등 예외가 발생한 경우 처리합니다.
                Log.d("서버값","실패")

            }
        })




        binding.leftArrowBtn.setOnClickListener {
            finish()
        }

        binding.starRecyclerView.layoutManager= LinearLayoutManager(this)
        val adapter=StarAdapter(dataDataList)
        binding.starRecyclerView.adapter=adapter




    }
}