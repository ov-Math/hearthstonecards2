package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Sets

class GetSets(private val repository: CardsRepository) {
    fun execute() : List<Sets> {
        return repository.getSets()
    }
}