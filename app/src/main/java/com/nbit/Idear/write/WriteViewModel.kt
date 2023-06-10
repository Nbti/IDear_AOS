package com.nbit.Idear.write

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WriteViewModel(private val repo: WriteRepository, val context: Context): ViewModel() {

    private val postQuery = HashMap<String, Any>()

    private val _chat = MutableLiveData<WriteResponseModel>()
    val chat: LiveData<WriteResponseModel> get() = _chat

    private val _profile = MutableLiveData<ProfileResponseModel>()
    val profile: LiveData<ProfileResponseModel> get() = _profile

    var dear: String = ""
    var type: String = ""
    var content: String = ""
    var userId: Int = 1
    var profiledId: Int = 12

    fun firstPage() {
        try {
            viewModelScope.launch {
                val response =  repo.postQuery(
                    WriteRequestModel(
                        dear, type, content, userId, profiledId))
                _chat.value = response.body()
                Log.d("TEST","${response.body()}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getProfile() {
        try {
            viewModelScope.launch {
                val response =  repo.getTest()
                _profile.value = response.body()
                Log.d("TEST","${response.body()}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun postFavorite(content: String) {
        try {
            viewModelScope.launch {
                repo.postFavorite(content)
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }
}