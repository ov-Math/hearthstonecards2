package com.example.data.repository

import com.example.data.services.ServicesFactory
import com.example.domain.core.CardsRepository
import com.example.domain.model.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CardsRepositoryImpl(val baseUrl : String) : CardsRepository {

    override fun getClasses(): List<Classes> {
        return mutableListOf(Classes.DRUID, Classes.HUNTER, Classes.MAGE, Classes.PALADIN, Classes.ROGUE, Classes.SHAMAN, Classes.WARLOCK, Classes.WARRIOR, Classes.DREAM)
    }

    override fun getRaces(): List<Races> {
        return mutableListOf(Races.DEMON, Races.DRAGON, Races.MECH, Races.MURLOC, Races.BEAST, Races.PIRATE, Races.TOTEM)
    }

    override fun getSets(): List<Sets> {
        return mutableListOf(Sets.BASIC, Sets.CLASSIC, Sets.CREDITS, Sets.NAXXRAMAS, Sets.DEBUG, Sets.GOBLINS_GNOMES, Sets.MISSIONS, Sets.PROMOTION, Sets.REWARD, Sets.SYSTEM, Sets.BLACKROCK_MOUNTAIN, Sets.HERO_SKINS, Sets.TAVERN_BRAWL, Sets.GRAND_TOURNAMENT)
    }

    override fun getTypes(): List<Types> {
        return mutableListOf(Types.HERO, Types.MINION, Types.SPELL, Types.ENCHANTMENT, Types.WEAPON, Types.HERO_POWER)
    }

    override fun getFactions(): List<Factions> {
        return mutableListOf(Factions.ALLIANCE, Factions.HORDE, Factions.NEUTRAL)
    }

    override fun getQualities(): List<Qualities> {
        return mutableListOf(Qualities.FREE, Qualities.COMMON, Qualities.RARE, Qualities.RARE, Qualities.LEGENDARY)
    }

    override fun getCardsByClass(cardClass : Classes): Single<List<CardDomain>> {
        return ServicesFactory.instance()
            .getCardsServices(baseUrl)
            .getCardsByClass(cardClass.text)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.map {
                    it.asDomainModel()
                })
            }
    }

    override fun getCardsBySet(set: Sets): Single<List<CardDomain>> {
        return ServicesFactory.instance()
            .getCardsServices(baseUrl)
            .getCardsBySet(set.text)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.map {
                    it.asDomainModel()
                })
            }
    }

    override fun getCardsByRace(race: Races): Single<List<CardDomain>> {
        return ServicesFactory.instance()
            .getCardsServices(baseUrl)
            .getCardsByRace(race.text)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.map {
                    it.asDomainModel()
                })
            }
    }

    override fun getCardsByQuality(quality: Qualities): Single<List<CardDomain>> {
        return ServicesFactory.instance()
            .getCardsServices(baseUrl)
            .getCardsByQuality(quality.text)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.map {
                    it.asDomainModel()
                })
            }
    }

    override fun getCardsByType(type: Types): Single<List<CardDomain>> {
        return ServicesFactory.instance()
            .getCardsServices(baseUrl)
            .getCardsByType(type.text)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.map {
                    it.asDomainModel()
                })
            }
    }

    override fun getCardsByFaction(faction: Factions): Single<List<CardDomain>> {
        return ServicesFactory.instance()
            .getCardsServices(baseUrl)
            .getCardsByFaction(faction.text)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Single.just(it.map {
                    it.asDomainModel()
                })
            }
    }
}