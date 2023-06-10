package com.nbit.Idear.write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nbit.Idear.R
import com.nbit.Idear.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    //private lateinit var writeViewModel : WriteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = WriteRepository()

        val viewModelFactory = WriteFactory(repository,this@WriteActivity)
        //writeViewModel = ViewModelProvider(this@WriteActivity, viewModelFactory)[WriteViewModel::class.java]

        supportFragmentManager.beginTransaction()
            .add(R.id.fl_write, WriteFirstFragment())  // fragment_container는 Fragment를 삽입할 레이아웃의 ID입니다.
            .commit()

    }
}