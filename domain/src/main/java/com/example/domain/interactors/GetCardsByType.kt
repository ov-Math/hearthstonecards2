package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.core.exceptions.InvalidFilterException
import com.example.domain.model.CardDomain
import com.example.domain.model.Types
import io.reactivex.rxjava3.core.Single

class GetCardsByType (val repository: CardsRepository) {

    private var type : Types? = null

    fun with(type : Types) : GetCardsByType {
        this.type = type
        return this
    }

    @Throws(InvalidFilterException::class)
    fun execute() : Single<List<CardDomain>> {
        if(this.type == null) {
            throw InvalidFilterException("Filter cannot be null")
        }

        return repository.getCardsByType(type!!)
    }
}