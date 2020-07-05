package com.example.hearthstone.core.koin

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module

object AppModule {
    fun get() = module {
        single<Gson> { GsonBuilder().serializeNulls().create() }
    }
}