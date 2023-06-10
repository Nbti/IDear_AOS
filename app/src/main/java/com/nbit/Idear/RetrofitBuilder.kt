package com.nbit.Idear

import com.nbit.Idear.write.WriteInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // 연결 시간 초과를 30초로 설정합니다.
        .readTimeout(30, TimeUnit.SECONDS) // 읽기 시간 초과를 30초로 설정합니다.
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.180.95.50:9010")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val writeApi: WriteInterface by lazy {
        retrofit.create(WriteInterface::class.java)
    }
}