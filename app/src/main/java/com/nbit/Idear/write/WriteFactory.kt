package com.nbit.Idear.write

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WriteFactory(private val repo: WriteRepository, private val context: Context): ViewModelProvider.Factory {
    override fun <T:ViewModel> create(modelClass: Class<T>): T {
        return WriteViewModel(repo, context) as T
    }
}