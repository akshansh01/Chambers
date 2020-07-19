package com.sirius.chambers.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.chambers.R
import kotlinx.android.synthetic.main.home_card_fragment.view.*

class HomeCardAdapter(private val cardList: List<HomeCardItem>) :
    RecyclerView.Adapter<HomeCardAdapter.HomeCardViewHolder>() {
    class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.home_card_imageview
        val textViewTop = itemView.home_card_textview_top
        val textViewBottom = itemView.home_card_textview_bottom
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.home_card_fragment, parent, false
        )
        return HomeCardViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        val currentItem = cardList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textViewTop.text = currentItem.textTop
        holder.textViewBottom.text = currentItem.textBottom
    }

    override fun getItemCount(): Int = cardList.size
}