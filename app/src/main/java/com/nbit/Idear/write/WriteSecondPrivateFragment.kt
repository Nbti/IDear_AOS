package com.nbit.Idear.write

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.nbit.Idear.R
import com.nbit.Idear.databinding.FragmentWriteFirstBinding
import com.nbit.Idear.databinding.FragmentWriteSecondPrivateBinding

class WriteSecondPrivateFragment : Fragment() {

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    private var next: Int = 0

    private var _binding: FragmentWriteSecondPrivateBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WriteViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteSecondPrivateBinding.inflate(inflater, container, false)

        val buttonTextList = listOf("우정","감사","입학 축하","조의","생일 축하","조언","격려","사랑", "인사") // 버튼에 표시할 텍스트 리스트
        flexBoxAdapter = FlexBoxAdapter(buttonTextList) { buttonText, selected ->
            // 버튼 클릭 이벤트 처리
            //데이터 처리
            if (selected) {
                next --
            } else {
                next ++
            }
            viewModel.type = buttonText
            onNextButton()
            Log.d("TEST","$next")
        }

        FlexboxLayoutManager(context).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }.let {
            binding.rvKeyword.layoutManager = it
            binding.rvKeyword.adapter = flexBoxAdapter
        }

        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fl_write, WriteThirdFragment())
                .addToBackStack("Write")
                .commit()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNextButton() {
        binding.btnNext.isEnabled = (next > 0)
    }


}