package com.nbit.Idear.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nbit.Idear.R
import com.nbit.Idear.databinding.FragmentAddProfileBinding


// 프로필 추가/수정
class AddProfileFragment : Fragment() {
    // ViewBinding Setting
    lateinit var binding: FragmentAddProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding Setting
        binding = FragmentAddProfileBinding.inflate(layoutInflater)
        return binding.root
    }
}