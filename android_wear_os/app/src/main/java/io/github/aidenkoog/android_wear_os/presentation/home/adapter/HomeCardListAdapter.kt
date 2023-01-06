package io.github.aidenkoog.android_wear_os.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import io.github.aidenkoog.android_wear_os.R
import io.github.aidenkoog.android_wear_os.domain.model.HomeCard

class HomeCardListAdapter(
    private val context: Context?, private var homeCardList: ArrayList<HomeCard>
) : RecyclerView.Adapter<HomeCardListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int, extras: Bundle?)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val homeCardTitle = itemView.findViewById<TextView>(R.id.homecard_title)

            homeCardTitle.text = homeCardList[position].title
            itemView.setOnClickListener {
                itemClickListener?.let {
                    it.onItemClick(position, null)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(
            R.layout.homecard_listitem_layout, parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list: ArrayList<HomeCard>) {
        homeCardList = list
        Logger.d("homeCardList size: ${homeCardList.size}")
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return homeCardList.size
    }
}