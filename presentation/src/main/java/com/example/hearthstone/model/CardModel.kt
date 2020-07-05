package com.example.hearthstone.model

import android.os.Parcelable
import com.example.domain.model.CardDomain
import kotlinx.android.parcel.Parcelize

@Parcelize
class CardModel (val cardId : String,
                 val name : String,
                 val img : String) : Parcelable {

    companion object {
        fun fromDomainObject(obj : CardDomain) : CardModel {
            return CardModel(obj.cardId, obj.name, obj.img)
        }
    }
}