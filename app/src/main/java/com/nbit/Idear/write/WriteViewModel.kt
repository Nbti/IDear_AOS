package com.nbit.Idear.write

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WriteViewModel(private val repo: WriteRepository, val context: Context): ViewModel() {


    fun test() {
        try {
            viewModelScope.launch {
                val response = repo.getTest()
                Log.d("TEST","${response.body()}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}