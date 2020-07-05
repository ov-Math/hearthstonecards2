package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.core.exceptions.InvalidFilterException
import com.example.domain.model.CardDomain
import com.example.domain.model.Races
import io.reactivex.rxjava3.core.Single

class GetCardsByRace (val repository: CardsRepository) {

    private var race : Races? = null

    fun with(race : Races) : GetCardsByRace {
        this.race = race
        return this
    }

    @Throws(InvalidFilterException::class)
    fun execute() : Single<List<CardDomain>> {
        if(this.race == null) {
            throw InvalidFilterException("Filter cannot be null")
        }

        return repository.getCardsByRace(race!!)
    }
}