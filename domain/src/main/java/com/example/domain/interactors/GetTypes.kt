package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Types

class GetTypes(private val repository: CardsRepository) {
    fun execute() : List<Types> {
        return repository.getTypes()
    }
}