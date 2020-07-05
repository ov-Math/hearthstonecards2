package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes

class GetClasses (private val repository: CardsRepository) {

    fun execute() : List<Classes> {
        return repository.getClasses()
    }
}