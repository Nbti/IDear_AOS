package com.nbit.Idear.write

import com.nbit.Idear.RetrofitBuilder
import retrofit2.Response

class WriteRepository {
    suspend fun getTest() : Response<Any> {
        return RetrofitBuilder.writeApi.getTest()
    }

}