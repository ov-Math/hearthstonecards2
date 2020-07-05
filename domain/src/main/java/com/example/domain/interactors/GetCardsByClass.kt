package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.core.exceptions.InvalidFilterException
import com.example.domain.model.CardDomain
import com.example.domain.model.Classes
import io.reactivex.rxjava3.core.Single

class GetCardsByClass (val repository: CardsRepository) {

    private var cardClass : Classes? = null

    fun with(cardClass : Classes) : GetCardsByClass {
        this.cardClass = cardClass
        return this
    }

    @Throws(InvalidFilterException::class)
    fun execute() : Single<List<CardDomain>> {
        if(this.cardClass == null) {
            throw InvalidFilterException("Filter cannot be null")
        }

        return repository.getCardsByClass(cardClass!!)
    }
}