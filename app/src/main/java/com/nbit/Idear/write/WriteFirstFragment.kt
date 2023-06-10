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

class WriteFirstFragment : Fragment() {

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    private var _binding: FragmentWriteFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteFirstBinding.inflate(inflater, container, false)

        val buttonTextList = listOf("가족","친구","동료","스승","연인","지인","제자","고객") // 버튼에 표시할 텍스트 리스트
        flexBoxAdapter = FlexBoxAdapter(buttonTextList) { buttonText ->
            // 버튼 클릭 이벤트 처리
            Toast.makeText(context,"클릭한 버튼: $buttonText",Toast.LENGTH_SHORT).show()
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


}