package com.nbit.Idear.write

import retrofit2.Response
import retrofit2.http.GET

interface WriteInterface {

    @GET("/mypage/profile")
    suspend fun getTest(

    ) : Response<Any>
}