package com.example.hearthstone.detail

import com.example.hearthstone.model.CardModel
import com.example.iddogs.core.BasePresenter

class CardDetailPresenter() : BasePresenter<CardDetailView>() {

    lateinit var card : CardModel

    companion object {
        const val CARD = "CARD"
    }
}