package com.nbit.Idear

import com.nbit.Idear.write.WriteInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://54.180.95.50:9010")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val writeApi: WriteInterface by lazy {
        retrofit.create(WriteInterface::class.java)
    }
}