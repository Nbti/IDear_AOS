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
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}