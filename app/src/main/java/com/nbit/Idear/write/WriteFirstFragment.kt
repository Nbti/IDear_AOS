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

class WriteFirstFragment : Fragment() {

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    private var _binding: FragmentWriteFirstBinding? = null
    private val binding get() = _binding!!

    private var select: Boolean = false
    private var selectItem: String = ""
    private var next: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteFirstBinding.inflate(inflater, container, false)

        val buttonTextList = listOf("가족","친구","동료","스승","연인","지인","제자","고객") // 버튼에 표시할 텍스트 리스트
        flexBoxAdapter = FlexBoxAdapter(buttonTextList) { buttonText, selected ->
            // 버튼 클릭 이벤트 처리
            if (selected) {
                next ++
            } else {
                next --
            }
            onNextButton()
            Toast.makeText(context,"클릭한 버튼: $buttonText",Toast.LENGTH_SHORT).show()
        }

        binding.btnPrivate.setOnClickListener {
            binding.btnPrivate.isSelected = true
            binding.btnPublic.isSelected = false
            select = true
            selectItem = "사적"
            onNextButton()
        }

        binding.btnPublic.setOnClickListener {
            binding.btnPrivate.isSelected = false
            binding.btnPublic.isSelected = true
            select = true
            selectItem = "공적"
            onNextButton()
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
            if (selectItem == "공적")
                parentFragmentManager.beginTransaction()
                    .add(R.id.fl_write, WriteSecondPublicFragment())
                    .addToBackStack("Write")
                    .commit()
            else
                parentFragmentManager.beginTransaction()
                    .add(R.id.fl_write, WriteSecondPrivateFragment())
                    .addToBackStack("Write")
                    .commit()
        }
        return binding.root
    }

    private fun onNextButton() {
        binding.btnNext.isEnabled = (next != 0 && select)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}