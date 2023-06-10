package com.nbit.Idear.write

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.nbit.Idear.R
import com.nbit.Idear.databinding.FragmentWriteFirstBinding
import com.nbit.Idear.databinding.FragmentWriteSecondPrivateBinding
import com.nbit.Idear.databinding.FragmentWriteThirdBinding

class WriteThirdFragment : Fragment() {

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    private var _binding: FragmentWriteThirdBinding? = null
    private val binding get() = _binding!!

    private var select: Boolean = false
    private var selectItem: String = ""
    private var next: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteThirdBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fl_write, WriteFourthFragment())
                    .addToBackStack("Write")
                    .commit()
        }

        val itemList = listOf<ProfileData>(
            ProfileData("깔끔한","ESTJ","반말"),
            ProfileData("까칠한","INTJ","반말"),
            ProfileData("귀여운","ENFP","존댓말"),
        )
        val adapter = ProfileAdapter(itemList) {
            //버튼 클릭 (수정하기)
        }
        binding.rvProfile.layoutManager = LinearLayoutManager(context)
        binding.rvProfile.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun hideKeyboard() {
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}