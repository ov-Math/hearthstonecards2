package com.example.hearthstone.cardlist

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstone.R

class CardListViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.cardImage)
}