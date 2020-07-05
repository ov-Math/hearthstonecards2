package com.example.hearthstone.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Classes
import com.example.domain.model.Filter
import com.example.hearthstone.R
import com.example.iddogs.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity(), MainView {

    private val presenter : MainPresenter by inject { parametersOf(this) }

    override fun onBackPressed() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        setupClassesList()
        setupFactionList()
        setupQualitiesList()
        setupRacesList()
        setupSetsList()
        setupTypeList()

        setupWelcomeText()

        logoutBtn.setOnClickListener {
            presenter.logout()
        }
    }

    private fun setupClassesList() {
        classesList.adapter = FilterAdapter(presenter.classesList, this)
        classesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupRacesList() {
        recesList.adapter = FilterAdapter(presenter.racesList, this)
        recesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupTypeList() {
        typesList.adapter = FilterAdapter(presenter.typesList, this)
        typesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupSetsList() {
        setsList.adapter = FilterAdapter(presenter.setsList, this)
        setsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupQualitiesList() {
        qualitiesList.adapter = FilterAdapter(presenter.qualitiesList, this)
        qualitiesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupFactionList() {
        factionList.adapter = FilterAdapter(presenter.factionList, this)
        factionList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onFilterSelected(filter: Filter) {
        presenter.getCardsByFilter(filter)
    }

    private fun setupWelcomeText() {
        welcome.text = getString(R.string.welcome_text, presenter.currentUser.name)
    }
}