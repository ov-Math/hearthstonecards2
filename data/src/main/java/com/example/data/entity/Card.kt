package com.example.data.entity

import com.example.domain.core.DomainMappable
import com.example.domain.model.CardDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Card (@Expose @SerializedName("cardId") val cardId : String = "",
            @Expose @SerializedName("name") val name : String = "",
            @Expose @SerializedName("img") val img : String = "") : DomainMappable<CardDomain> {

    override fun asDomainModel(): CardDomain {
        return CardDomain(this.cardId, this.name, this.img)
    }
}