package com.example.hearthstone.cardlist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hearthstone.R
import com.example.hearthstone.model.CardModel
import com.example.iddogs.core.BaseActivity
import kotlinx.android.synthetic.main.activity_card_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CardListActivity : BaseActivity(), CardListView {

    private val presenter : CardListPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)

        presenter.attachView(this)
        presenter.cardList = intent.getParcelableArrayExtra(CardListPresenter.CARD_LIST).map { it as CardModel }

        updateActivityTitle(intent.getStringExtra(CardListPresenter.ACTIVITY_TITLE))
        setupCardList()

        backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    private fun updateActivityTitle(newTitle : String) {
        activityTile.text = newTitle
    }

    private fun setupCardList() {
        list.adapter = CardListAdapter(presenter.cardList, this)
        list.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onCardClick(card : CardModel, view : View) {
        presenter.navigateDetails(card, view)
    }
}