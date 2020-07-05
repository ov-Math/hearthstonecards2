package com.example.hearthstone.cardlist

import android.view.View
import com.example.hearthstone.model.CardModel
import com.example.iddogs.core.BaseView

interface CardListView : BaseView {
    fun onCardClick(card : CardModel, view : View)
}