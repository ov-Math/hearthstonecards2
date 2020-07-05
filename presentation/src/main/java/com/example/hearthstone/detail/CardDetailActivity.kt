package com.example.hearthstone.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.hearthstone.R
import com.example.hearthstone.cardlist.CardListActivity
import com.example.hearthstone.cardlist.CardListPresenter
import com.example.iddogs.core.BaseActivity
import kotlinx.android.synthetic.main.activity_card_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CardDetailActivity : BaseActivity(), CardDetailView {

    private val presenter : CardDetailPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        presenter.attachView(this)
        presenter.card = intent.getParcelableExtra(CardDetailPresenter.CARD)

        setupDetails()

        backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupDetails() {
        id.text = presenter.card.cardId
        name.text = presenter.card.name

        if(presenter.card.img.isNullOrBlank()) {
            Glide.with(this).load(CardListPresenter.DEFAULT_CARD_IMG).into(cardImage)
        } else {
            val imageUrl = CardListPresenter.IMAGE_BASE_URL + presenter.card.cardId + CardListPresenter.IMAGE_EXTENSION
            Glide.with(this).load(imageUrl).into(cardImage)
        }
    }
}