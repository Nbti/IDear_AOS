package com.nbit.Idear.write

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.nbit.Idear.R
import com.nbit.Idear.databinding.FragmentWriteFirstBinding
import com.nbit.Idear.databinding.FragmentWriteSecondPrivateBinding
import com.nbit.Idear.databinding.FragmentWriteThirdBinding
import com.nbit.Idear.mypage.AddProfileActivity

class WriteThirdFragment : Fragment() {

    private lateinit var flexBoxAdapter: FlexBoxAdapter

    private var _binding: FragmentWriteThirdBinding? = null
    private val binding get() = _binding!!

    private var select: Boolean = false
    private var selectItem: String = ""
    private var next: Int = 0

    private val viewModel: WriteViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWriteThirdBinding.inflate(inflater, container, false)

        viewModel.getProfile()
        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fl_write, WriteFourthFragment())
                .addToBackStack("Write")
                .commit()
        }

        val drawableArray = arrayOf(
            R.drawable.ic_drawable_1,
            R.drawable.ic_drawable_2,
            R.drawable.ic_drawable_3,
            R.drawable.ic_drawable_4,
            R.drawable.ic_drawable_5,
            R.drawable.ic_drawable_6,
            R.drawable.ic_drawable_7,
            R.drawable.ic_drawable_8,
        )

        viewModel.profile.observe(viewLifecycleOwner) {
            val list = viewModel.profile.value?.result
            val itemList = mutableListOf<ProfileData>()

            if (list != null) {
                for (i in list) {
                    val randomIndex = (drawableArray.indices).random()
                    itemList.add(ProfileData(i.profileKeyword?:"", i.mbti?:"", if (i.is_polite) "존댓말" else "반말", drawableArray[randomIndex], i.id?:1))
                }
            }

            val adapter = ProfileAdapter(itemList, requireContext()) {
                val intent = Intent(requireContext(), AddProfileActivity::class.java)
                intent.putExtra("mode", "edit")
                startActivity(intent)
            }
            binding.rvProfile.layoutManager = LinearLayoutManager(context)
            binding.rvProfile.adapter = adapter
        }
        binding.btnAdd.setOnClickListener {
            val intent = Intent(requireContext(), AddProfileActivity::class.java)
            intent.putExtra("mode", "add")
            startActivity(intent)
        }

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