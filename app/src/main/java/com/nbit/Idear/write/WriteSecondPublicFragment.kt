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
import com.nbit.Idear.databinding.FragmentWriteSecondPublicBinding

class WriteSecondPublicFragment : Fragment() {

    private lateinit var flexBoxAdapter: FlexBoxAdapter


    private var next: Int = 0

    private var _binding: FragmentWriteSecondPublicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteSecondPublicBinding.inflate(inflater, container, false)

        val buttonTextList = listOf("추천서","내용확인","문의 사항","조의","인사","상업적 제안서","면담 요청","상담 요청", "클레임", "조언") // 버튼에 표시할 텍스트 리스트
        flexBoxAdapter = FlexBoxAdapter(buttonTextList) { buttonText, selected ->
            // 버튼 클릭 이벤트 처리
            //데이터 처리
            if (selected) {
                next ++
            } else {
                next --
            }
            onNextButton()
            Toast.makeText(context,"클릭한 버튼: $buttonText",Toast.LENGTH_SHORT).show()
        }
        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fl_write, WriteThirdFragment())
                .addToBackStack("Write")
                .commit()
        }

        FlexboxLayoutManager(context).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }.let {
            binding.rvKeyword.layoutManager = it
            binding.rvKeyword.adapter = flexBoxAdapter
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun onNextButton() {
        binding.btnNext.isEnabled = (next != 0)
    }


}