package com.example.hearthstone.main

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Filter
import com.example.hearthstone.R
import java.util.*

class FilterAdapter(): RecyclerView.Adapter<FilterViewHolder>() {
    lateinit var activity : MainView
    lateinit var options: List<Filter>
    val random = Random()

    constructor(options: List<Filter>, activity: MainView) : this() {
        this.activity = activity
        this.options = options
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.filter_card, parent, false)
        return FilterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val currentItem = options[position]

        holder.filterText.text = currentItem.text
        holder.card.backgroundTintList = ColorStateList.valueOf(generateRandomColor())

        holder.card.setOnClickListener {
            activity.onFilterSelected(currentItem)
        }
        holder.filterText.setOnClickListener {
            activity.onFilterSelected(currentItem)
        }

    }

    private fun generateRandomColor() : Int {
        return Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255))
    }

    override fun getItemCount(): Int {
        return options.size
    }
}