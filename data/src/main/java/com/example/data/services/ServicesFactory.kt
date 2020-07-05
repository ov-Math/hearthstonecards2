package com.example.data.services

import com.example.data.core.RequestManager

internal class ServicesFactory {

    companion object {
        //Singleton
        private var instance : ServicesFactory? = null

        @Synchronized
        fun instance() : ServicesFactory {
            if(instance == null){
                instance = ServicesFactory()
            }
            return instance!!
        }
    }

    // Singletons
    private var cardsServices: CardsServices? = null

    fun getCardsServices(baseUrl : String) : CardsServices {
        val retrofit = RequestManager.provideRetrofit(baseUrl)
        if(cardsServices == null) {
            cardsServices = retrofit.create(CardsServices::class.java)
        }
        return cardsServices!!
    }

}