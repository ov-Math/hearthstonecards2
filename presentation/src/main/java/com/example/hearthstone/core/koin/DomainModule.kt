package com.example.hearthstone.core.koin

import com.example.domain.interactors.*
import org.koin.dsl.module

object DomainModule {
    fun get() = module {
        single { GetClasses(get()) }
        single { GetRaces(get()) }
        single { GetFactions(get()) }
        single { GetQualities(get()) }
        single { GetSets(get()) }
        single { GetTypes(get()) }
        single { GetCardsByClass(get()) }
        single { GetCardsBySet(get()) }
        single { GetCardsByRace(get()) }
        single { GetCardsByQuality(get()) }
        single { GetCardsByType(get()) }
        single { GetCardsByFaction(get()) }
        single { EmailValidator() }
        single { GetCacheObject(get()) }
        single { PutCacheObject(get()) }
        single { DeleteCacheObject(get()) }
    }
}