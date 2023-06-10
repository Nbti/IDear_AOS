package com.nbit.Idear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.nbit.Idear.databinding.ActivityMainBinding
import com.nbit.Idear.databinding.MainIncludeDrawerBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding Setting
    lateinit var drawerBinding: MainIncludeDrawerBinding
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding Setting
        drawerBinding = MainIncludeDrawerBinding.inflate(layoutInflater)
        setContentView(drawerBinding.root)

        mainBinding = drawerBinding.includeMainActivity
        mainBinding.btnOpenMenu.setOnClickListener {
            drawerBinding.mainDrawerLayout.openDrawer((GravityCompat.END))
        }
    }
}