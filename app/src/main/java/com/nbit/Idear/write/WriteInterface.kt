package com.nbit.Idear.write

import retrofit2.Response
import retrofit2.http.*

interface WriteInterface {

    @GET("/mypage/profile")
    suspend fun getTest(

    ) : Response<Any>

    @POST("/app/home/query")
    suspend fun postQuery(
        @Body params: WriteRequestModel
    ): Response<WriteResponseModel>
}