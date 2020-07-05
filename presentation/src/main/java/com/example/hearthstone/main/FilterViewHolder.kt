package com.example.hearthstone.main

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hearthstone.R

class FilterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val card = itemView.findViewById<ConstraintLayout>(R.id.card)
    val filterText = itemView.findViewById<TextView>(R.id.filterText)
}