package com.example.data.services

import com.example.data.entity.Card
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CardsServices {

    @GET("cards/classes/{class}")
    fun getCardsByClass(
        @Path("class") cardClass : String
    ) : Single<List<Card>>

    @GET("cards/sets/{set}")
    fun getCardsBySet(
        @Path("set") set : String
    ) : Single<List<Card>>

    @GET("cards/races/{race}")
    fun getCardsByRace(
        @Path("race") race : String
    ) : Single<List<Card>>

    @GET("cards/qualities/{quality}")
    fun getCardsByQuality(
        @Path("quality") quality : String
    ) : Single<List<Card>>

    @GET("cards/types/{type}")
    fun getCardsByType(
        @Path("type") type : String
    ) : Single<List<Card>>

    @GET("cards/factions/{faction}")
    fun getCardsByFaction(
        @Path("faction") faction : String
    ) : Single<List<Card>>
}