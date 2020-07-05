package com.example.hearthstone.cardlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hearthstone.R
import com.example.hearthstone.model.CardModel

class CardListAdapter () : RecyclerView.Adapter<CardListViewHolder>() {
    lateinit var activity : CardListView
    lateinit var array : List<CardModel>

    constructor(array: List<CardModel>, activity: CardListView) : this() {
        this.activity = activity
        this.array = array
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return CardListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        val currentItem = array[position]

        if(currentItem.img.isNullOrBlank()) {
            Glide.with(activity as CardListActivity).load(CardListPresenter.DEFAULT_CARD_IMG).into(holder.image)
        } else {
            val imageUrl = CardListPresenter.IMAGE_BASE_URL + currentItem.cardId + CardListPresenter.IMAGE_EXTENSION
            Glide.with(activity as CardListActivity).load(imageUrl).into(holder.image)
        }

        holder.image.setOnClickListener {
            activity.onCardClick(currentItem, holder.image)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}