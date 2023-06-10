package com.nbit.Idear.write

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nbit.Idear.R

class ProfileAdapter(private val profileList: List<ProfileData>, private val buttonClickListener: () -> Unit): RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile_list2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = profileList[position]

        holder.tvProfile.text = "${text.mood} ${text.mbti} (${text.formal})"

        holder.btnEditProfile.setOnClickListener {
            buttonClickListener.invoke()
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnEditProfile: Button = itemView.findViewById(R.id.btn_edit_profile)
        val tvProfile: TextView = itemView.findViewById(R.id.tv_profile)
    }
}

data class ProfileData(
    var mood: String,
    var mbti: String,
    var formal: String
)