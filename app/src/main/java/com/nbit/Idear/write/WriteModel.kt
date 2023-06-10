package com.nbit.Idear.write

data class WriteRequestModel(
    var dear: String,
    var type: String,
    var content: String,
    var userId: Int = 1,
    var profileId: Int
)

data class WriteResponseModel(
    var result: WriteResponseModel2
)
data class WriteResponseModel2(
    var dear: String,
    var type: String,
    var createAt: String,
    var contentRes: ContentResModel,
)

data class ContentResModel(
    var message: String,
    var finishReason: String
)