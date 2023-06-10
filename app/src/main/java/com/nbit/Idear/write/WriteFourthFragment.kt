package com.nbit.Idear.write

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.nbit.Idear.databinding.FragmentWriteFourthBinding
import com.nbit.Idear.text.AiTextAdapter
import com.nbit.Idear.text.AiTextResult


class WriteFourthFragment : Fragment() {

    private var _binding: FragmentWriteFourthBinding? = null
    private val binding get() = _binding!!

    private var keyboardIsOpen: Boolean = false

    private val viewModel: WriteViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteFourthBinding.inflate(inflater, container, false)

        viewModel.firstPage()

        var aiTextAdapter = AiTextAdapter() { aa, type ->
            when (type) {
                0 -> {
                    //즐겨찾기 추가
                }
                1 -> {
                    val intent= Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT,aa.trim())
                    startActivity(Intent.createChooser(intent,"공유하기"))
                }
                2 -> {
                    activity?.finish()
                }
            }

        }

        binding.viewpagerText.adapter = aiTextAdapter

        val pageMargin = resources.getDimensionPixelOffset(com.nbit.Idear.R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(com.nbit.Idear.R.dimen.offset).toFloat()
        binding.viewpagerText.offscreenPageLimit = 3
        binding.viewpagerText.setPageTransformer(ViewPager2.PageTransformer { page, position ->
            val myOffset = position * -(2 * pageOffset + pageMargin)
            if (binding.viewpagerText.orientation === ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(binding.viewpagerText) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -myOffset
                } else {
                    page.translationX = myOffset
                }
            } else {
                page.translationY = myOffset
            }
        })

        binding.btnRequest.setOnClickListener {
            viewModel.firstPage()

        }

        viewModel.chat.observe(viewLifecycleOwner) {
            binding.itemTextProfile.tvDate.text = it.result.createAt
            //binding.itemTextProfile.tvTitle.text = "[${it.result.dear}]에게 전하는 ${it.result.type}"
            aiTextAdapter.addItem(AiTextResult(it.result.contentRes.message?:"", false))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.viewTreeObserver.addOnGlobalLayoutListener {
            val rootView = view.rootView
            val heightDiff = rootView.height - view.height
            val keyboardOpenThreshold = rootView.height * 0.15

            if (heightDiff > keyboardOpenThreshold && !keyboardIsOpen) {
                // 키보드가 활성화됨
                keyboardIsOpen = true
                binding.btnRequest.visibility = View.INVISIBLE
            } else if (heightDiff < keyboardOpenThreshold && keyboardIsOpen) {
                // 키보드가 비활성화됨
                keyboardIsOpen = false
                binding.btnRequest.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}