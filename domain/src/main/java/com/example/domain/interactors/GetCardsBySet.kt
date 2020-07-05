package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.core.exceptions.InvalidFilterException
import com.example.domain.model.CardDomain
import com.example.domain.model.Sets
import io.reactivex.rxjava3.core.Single

class GetCardsBySet (val repository: CardsRepository) {

    private var set : Sets? = null

    fun with(set : Sets) : GetCardsBySet {
        this.set = set
        return this
    }

    @Throws(InvalidFilterException::class)
    fun execute() : Single<List<CardDomain>> {
        if(this.set == null) {
            throw InvalidFilterException("Filter cannot be null")
        }

        return repository.getCardsBySet(set!!)
    }
}