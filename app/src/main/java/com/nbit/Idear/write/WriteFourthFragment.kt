package com.nbit.Idear.write

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.nbit.Idear.databinding.FragmentWriteFourthBinding
import com.nbit.Idear.text.AiTextAdapter
import com.nbit.Idear.text.AiTextResult


class WriteFourthFragment : Fragment() {

    private var _binding: FragmentWriteFourthBinding? = null
    private val binding get() = _binding!!

    private var keyboardIsOpen: Boolean = false

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
            val item4 = AiTextResult("123123123123",false)
            aiTextAdapter.addItem(item4)
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