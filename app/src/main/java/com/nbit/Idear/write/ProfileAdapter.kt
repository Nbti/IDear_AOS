package com.nbit.Idear.write

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R

class ProfileAdapter(private val profileList: List<ProfileData>, private val context: Context, private val buttonClickListener: () -> Unit): RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile_list2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = profileList[position]
        holder.ivProfile.setImageDrawable(ContextCompat.getDrawable(context, text.drawable))
        holder.tvProfile.text = "${text.mood} ${text.mbti} (${text.formal})"
        holder.btnEditProfile.setOnClickListener {
            buttonClickListener.invoke()
        }
        holder.itemView.setOnClickListener {
            holder.itemView.isSelected = !holder.itemView.isSelected
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnEditProfile: Button = itemView.findViewById(R.id.btn_edit_profile)
        val tvProfile: TextView = itemView.findViewById(R.id.tv_profile)
        val ivProfile: ImageFilterView = itemView.findViewById(R.id.profile_icon)
    }
}

data class ProfileData(
    var mood: String,
    var mbti: String,
    var formal: String,
    var drawable: Int,
    var id: Int
)