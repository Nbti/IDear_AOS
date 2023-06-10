package com.nbit.Idear.write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.nbit.Idear.R
import com.nbit.Idear.databinding.FragmentWriteFirstBinding
import com.nbit.Idear.databinding.FragmentWriteFourthBinding
import com.nbit.Idear.databinding.FragmentWriteSecondPrivateBinding
import com.nbit.Idear.databinding.FragmentWriteThirdBinding
import com.nbit.Idear.text.AiTextAdapter
import com.nbit.Idear.text.AiTextResult

class WriteFourthFragment : Fragment() {

    private var _binding: FragmentWriteFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteFourthBinding.inflate(inflater, container, false)

        var aiTextAdapter = AiTextAdapter()


        val item1 = AiTextResult("1231123123",false)
        val item2 = AiTextResult("2231123123",false)
        val item3 = AiTextResult("333",false)

        aiTextAdapter.addItem(item1)
        aiTextAdapter.addItem(item2)
        aiTextAdapter.addItem(item3)
        binding.viewpagerText.adapter = aiTextAdapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}