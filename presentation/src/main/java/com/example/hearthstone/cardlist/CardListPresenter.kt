package com.example.hearthstone.cardlist

import android.view.View
import com.example.hearthstone.core.Navigator
import com.example.hearthstone.model.CardModel
import com.example.iddogs.core.BasePresenter

class CardListPresenter(private val navigator: Navigator) : BasePresenter<CardListView>() {

    companion object {
        const val CARD_LIST = "CARD_LIST"
        const val ACTIVITY_TITLE = "ACTIVITY_TITLE"
        const val DEFAULT_CARD_IMG = "https://wow.zamimg.com/images/hearthstone/backs/original/Card_Back_Default.png"
        const val IMAGE_BASE_URL = "https://art.hearthstonejson.com/v1/render/latest/enUS/256x/"
        const val IMAGE_EXTENSION = ".png"
    }

    lateinit var cardList : List<CardModel>

    fun navigateDetails(card : CardModel, view : View) {
        navigator.navigateDetails(card, view)
    }
}