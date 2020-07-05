package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Qualities

class GetQualities(private val repository: CardsRepository) {
    fun execute() : List<Qualities> {
        return repository.getQualities()
    }
}