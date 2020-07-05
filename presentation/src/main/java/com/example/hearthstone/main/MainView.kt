package com.example.hearthstone.main

import com.example.domain.model.Filter
import com.example.iddogs.core.BaseView

interface MainView : BaseView {
    fun onFilterSelected(filter : Filter)
}