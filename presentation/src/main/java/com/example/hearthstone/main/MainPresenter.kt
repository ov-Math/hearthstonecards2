package com.example.hearthstone.main

import com.example.domain.core.CacheKey
import com.example.domain.interactors.*
import com.example.domain.model.*
import com.example.hearthstone.core.Navigator
import com.example.hearthstone.model.CardModel
import com.example.iddogs.core.BasePresenter

class MainPresenter (private val navigator: Navigator,
                     private val getClasses: GetClasses,
                     private val getRaces: GetRaces,
                     private val getTypes: GetTypes,
                     private val getSets: GetSets,
                     private val getQualities: GetQualities,
                     private val getFactions: GetFactions,
                     private val getCardsByClass: GetCardsByClass,
                     private val getCardsBySet: GetCardsBySet,
                     private val getCardsByRace: GetCardsByRace,
                     private val getCardsByQuality: GetCardsByQuality,
                     private val getCardsByType: GetCardsByType,
                     private val getCardsByFaction: GetCardsByFaction,
                     private val deleteCacheObject: DeleteCacheObject,
                     private val getCacheObject: GetCacheObject) : BasePresenter<MainView>() {

    var classesList = getClasses.execute()
    var racesList = getRaces.execute()
    var typesList = getTypes.execute()
    var setsList = getSets.execute()
    var qualitiesList = getQualities.execute()
    var factionList = getFactions.execute()
    var currentUser = getCurrentUserFromCache()

    fun logout() {
        deleteCacheObject
            .with(CacheKey.USER)
            .execute()
        navigateLogin()
    }

    private fun getCurrentUserFromCache() : UserDomain {
        val currentUser = getCacheObject
            .with(CacheKey.USER, UserDomain::class.java)
            .execute()

        return currentUser as UserDomain
    }

    fun getCardsByFilter(filter : Filter) {
        view?.showLoading()
        when(filter) {
            is Classes -> {
                getCardsByClass(filter)
            }
            is Sets -> {
                getCardsBySet(filter)
            }
            is Races -> {
                getCardsByRace(filter)
            }
            is Qualities -> {
                getCardsByQuality(filter)
            }
            is Types -> {
                getCardsByType(filter)
            }
            is Factions -> {
                getCardsByFaction(filter)
            }
        }
    }

    private fun getCardsByClass(cardClass : Classes) {
        getCardsByClass
            .with(cardClass)
            .execute()
            .subscribe({
                navigateCardLit(it, cardClass.text)
                view?.hideLoading()
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    private fun getCardsBySet(set : Sets) {
        getCardsBySet
            .with(set)
            .execute()
            .subscribe({
                navigateCardLit(it, set.text)
                view?.hideLoading()
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    private fun getCardsByRace(race : Races) {
        getCardsByRace
            .with(race)
            .execute()
            .subscribe({
                navigateCardLit(it, race.text)
                view?.hideLoading()
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    private fun getCardsByQuality(quality : Qualities) {
        getCardsByQuality
            .with(quality)
            .execute()
            .subscribe({
                navigateCardLit(it, quality.text)
                view?.hideLoading()
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    private fun getCardsByType(type : Types) {
        getCardsByType
            .with(type)
            .execute()
            .subscribe({
                navigateCardLit(it, type.text)
                view?.hideLoading()
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    private fun getCardsByFaction(factions: Factions) {
        getCardsByFaction
            .with(factions)
            .execute()
            .subscribe({
                navigateCardLit(it, factions.text)
                view?.hideLoading()
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }

    private fun navigateCardLit(list : List<CardDomain>, filterText : String) {
        navigator.navigateCardList(getCardModelArrayFromCardDomainList(list), filterText)
    }

    private fun getCardModelArrayFromCardDomainList(list : List<CardDomain>) : Array<CardModel> {
        return list.map { CardModel.fromDomainObject(it) }.toTypedArray()
    }

    private fun navigateLogin() {
        navigator.navigateLogin()
    }

}