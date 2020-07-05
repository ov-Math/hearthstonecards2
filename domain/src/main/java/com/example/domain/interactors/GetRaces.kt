package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Races

class GetRaces(private val repository: CardsRepository) {
    fun execute() : List<Races> {
        return repository.getRaces()
    }
}