package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Factions

class GetFactions(private val repository: CardsRepository) {
    fun execute() : List<Factions> {
        return repository.getFactions()
    }
}