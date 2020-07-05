package com.example.hearthstone.core

import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import com.example.hearthstone.cardlist.CardListActivity
import com.example.hearthstone.cardlist.CardListPresenter
import com.example.hearthstone.detail.CardDetailActivity
import com.example.hearthstone.detail.CardDetailPresenter
import com.example.hearthstone.login.LoginActivity
import com.example.hearthstone.main.MainActivity
import com.example.hearthstone.model.CardModel
import com.example.iddogs.core.BaseActivity

class Navigator (private val activity: BaseActivity) {

    fun navigateCardList(list : Array<CardModel>, activityTitle : String) {
        val intent = Intent(activity, CardListActivity::class.java)
        intent.putExtra(CardListPresenter.CARD_LIST, list)
        intent.putExtra(CardListPresenter.ACTIVITY_TITLE, activityTitle)
        activity.startActivity(intent)
    }

    fun navigateMain() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    fun navigateLogin() {
        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
    }

    fun navigateDetails(card : CardModel, cardView : View) {
        val intent = Intent(activity, CardDetailActivity::class.java)
        val transition = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, cardView, "cardTransition")
        intent.putExtra(CardDetailPresenter.CARD, card)
        activity.startActivity(intent, transition.toBundle())
    }
}