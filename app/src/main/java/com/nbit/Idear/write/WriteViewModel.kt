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

    fun firstPage() {
        try {
            viewModelScope.launch {
                val response =  repo.postQuery(
                    WriteRequestModel(
                        "Friend",
                        "advice",
                        "Advice for friends who don't get along with their parents",
                        1,
                        12))
                _chat.value = response.body()
                Log.d("TEST","${response.body()}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}