package com.example.hearthstone.core.koin

import com.example.data.repository.CacheRepositoryImpl
import com.example.data.repository.CardsRepositoryImpl
import com.example.domain.core.CacheRepository
import com.example.domain.core.CardsRepository
import com.example.hearthstone.core.HearthstoneCardsApp
import org.koin.dsl.module

object DataModule {
    fun get() = module {
        single<CardsRepository> { CardsRepositoryImpl("https://omgvamp-hearthstone-v1.p.rapidapi.com/") }
        single<CacheRepository> { CacheRepositoryImpl(HearthstoneCardsApp.appContext) }
    }
}