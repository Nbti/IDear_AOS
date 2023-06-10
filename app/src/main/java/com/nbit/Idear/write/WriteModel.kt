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
    var id: Int,
    var dear: String,
    var type: String,
    var createAt: String,
    var contentRes: ContentResModel,
)

data class ContentResModel(
    var id: Int,
    var message: String,
    var finishReason: String
)

data class ProfileResponseModel(
    var result: List<ProfileResponseModel2>
)

data class ProfileResponseModel2(
    var id : Int,
    var is_polite: Boolean = false,
    var mbti: String,
    var profileKeyword: String,
    var user: UserResponseModel
)

data class UserResponseModel(
    var id: Int,
    var name:String,
    var email: String,
    var password: String
)