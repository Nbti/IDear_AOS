package com.nbit.Idear.write

import com.nbit.Idear.RetrofitBuilder
import retrofit2.Response

class WriteRepository {
    suspend fun getTest() : Response<ProfileResponseModel> {
        return RetrofitBuilder.writeApi.getTest()
    }

    suspend fun postQuery(params: WriteRequestModel) : Response<WriteResponseModel> {
        return RetrofitBuilder.writeApi.postQuery(params)
    }

    suspend fun postFavorite(content: String) {
        RetrofitBuilder.writeApi.postFavorite(content)
    }

    suspend fun postFeedback(content: String, id: Int ) : Response<WriteResponseModel>{
        return RetrofitBuilder.writeApi.postFeedback(id, content)
    }
}