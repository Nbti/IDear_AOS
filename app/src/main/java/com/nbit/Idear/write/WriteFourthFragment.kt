package com.nbit.Idear.write

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
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

        binding.itemTextProfile.tvDate.text = "2023-06-11"
        binding.itemTextProfile.tvTitle.text = "[${viewModel.dear}]에게 전하는 ${viewModel.type}"

        val drawableArray = arrayOf(
            com.nbit.Idear.R.drawable.ic_drawable_1,
            com.nbit.Idear.R.drawable.ic_drawable_2,
            com.nbit.Idear.R.drawable.ic_drawable_3,
            com.nbit.Idear.R.drawable.ic_drawable_4,
            com.nbit.Idear.R.drawable.ic_drawable_5,
            com.nbit.Idear.R.drawable.ic_drawable_6,
            com.nbit.Idear.R.drawable.ic_drawable_7,
            com.nbit.Idear.R.drawable.ic_drawable_8,
        )

        val randomIndex = (drawableArray.indices).random()
        binding.itemTextProfile.ivProfile.setImageDrawable(ContextCompat.getDrawable(requireContext(), drawableArray[randomIndex]))

        var aiTextAdapter = AiTextAdapter() { aa, type ->
            when (type) {
                0 -> {
                    viewModel.postFavorite(aa)
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

        binding.btnNavi.setOnClickListener {
            viewModel.postFeedback(binding.etFeedback.text.toString())
            binding.etFeedback.text.clear()
        }

        binding.btnRequest.setOnClickListener {
            viewModel.firstPage()

        }

        viewModel.chat.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "새로운 답변이 도착했습니다.",Toast.LENGTH_SHORT).show()
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