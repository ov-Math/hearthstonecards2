package com.example.data.repository

import com.example.data.entity.Card
import com.example.domain.model.*
import com.google.gson.Gson
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException

@RunWith(JUnit4::class)
class CardsRepositoryImplTest {

    private val serverPort = 1234
    private val mockWebServer = MockWebServer()
    private lateinit var repository : CardsRepositoryImpl

    val cardList = listOf(Card("", "", ""), Card("", "", ""))

    @Before
    fun setup() {
        /* Rx Setup */
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        /* Server setup */
        mockWebServer.start(serverPort)

        repository = CardsRepositoryImpl(mockWebServer.url("/").toString())
    }

    @After
    fun destroy() {
        mockWebServer.shutdown()
    }

    @Test
    fun getClasses_expectedResult() {
        val classesList = mutableListOf(Classes.DRUID, Classes.HUNTER, Classes.MAGE, Classes.PALADIN, Classes.ROGUE, Classes.SHAMAN, Classes.WARLOCK, Classes.WARRIOR, Classes.DREAM)
        val result = repository.getClasses()
        Assert.assertEquals(classesList, result)
    }

    @Test
    fun getRaces_expectedResult() {
        val racesList = mutableListOf(Races.DEMON, Races.DRAGON, Races.MECH, Races.MURLOC, Races.BEAST, Races.PIRATE, Races.TOTEM)
        val result = repository.getRaces()
        Assert.assertEquals(racesList, result)
    }

    @Test
    fun getSets_expectedResult() {
        val setsList = mutableListOf(Sets.BASIC, Sets.CLASSIC, Sets.CREDITS, Sets.NAXXRAMAS, Sets.DEBUG, Sets.GOBLINS_GNOMES, Sets.MISSIONS, Sets.PROMOTION, Sets.REWARD, Sets.SYSTEM, Sets.BLACKROCK_MOUNTAIN, Sets.HERO_SKINS, Sets.TAVERN_BRAWL, Sets.GRAND_TOURNAMENT)
        val result = repository.getSets()
        Assert.assertEquals(setsList, result)
    }

    @Test
    fun getTypes_expectedResult() {
        val typesList = mutableListOf(Types.HERO, Types.MINION, Types.SPELL, Types.ENCHANTMENT, Types.WEAPON, Types.HERO_POWER)
        val result = repository.getTypes()
        Assert.assertEquals(typesList, result)
    }

    @Test
    fun getFactions_expectedResult() {
        val factionsList = mutableListOf(Factions.ALLIANCE, Factions.HORDE, Factions.NEUTRAL)
        val result = repository.getFactions()
        Assert.assertEquals(factionsList, result)
    }

    @Test
    fun getQualities_expectedResult() {
        val qualitiesList = mutableListOf(Qualities.FREE, Qualities.COMMON, Qualities.RARE, Qualities.RARE, Qualities.LEGENDARY)
        val result = repository.getQualities()
        Assert.assertEquals(qualitiesList, result)
    }

    @Test
    fun getCardsByClass_expectedResult() {
        setupSuccess()

        val response = repository.getCardsByClass(Classes.DREAM).test()
        val result = response.values().first()

        response.assertComplete()
        response.assertNoErrors()
        response.dispose()

        Assert.assertEquals(cardList[0].cardId, result[0].cardId)
        Assert.assertEquals(cardList[0].name, result[0].name)
        Assert.assertEquals(cardList[0].img, result[0].img)
        Assert.assertEquals(cardList[1].cardId, result[1].cardId)
        Assert.assertEquals(cardList[1].name, result[1].name)
        Assert.assertEquals(cardList[1].img, result[1].img)
    }

    @Test
    fun getCardsByClass_httpError() {
        setupFail()

        val response = repository.getCardsByClass(Classes.DREAM).test()

        response.assertError(HttpException::class.java)
    }

    @Test
    fun getCardsByRace_expectedResult() {
        setupSuccess()

        val response = repository.getCardsByRace(Races.PIRATE).test()
        val result = response.values().first()

        response.assertComplete()
        response.assertNoErrors()
        response.dispose()

        Assert.assertEquals(cardList[0].cardId, result[0].cardId)
        Assert.assertEquals(cardList[0].name, result[0].name)
        Assert.assertEquals(cardList[0].img, result[0].img)
        Assert.assertEquals(cardList[1].cardId, result[1].cardId)
        Assert.assertEquals(cardList[1].name, result[1].name)
        Assert.assertEquals(cardList[1].img, result[1].img)
    }

    @Test
    fun getCardsByRace_httpError() {
        setupFail()

        val response = repository.getCardsByRace(Races.PIRATE).test()

        response.assertError(HttpException::class.java)
    }

    @Test
    fun getCardsByType_expectedResult() {
        setupSuccess()

        val response = repository.getCardsByType(Types.HERO).test()
        val result = response.values().first()

        response.assertComplete()
        response.assertNoErrors()
        response.dispose()

        Assert.assertEquals(cardList[0].cardId, result[0].cardId)
        Assert.assertEquals(cardList[0].name, result[0].name)
        Assert.assertEquals(cardList[0].img, result[0].img)
        Assert.assertEquals(cardList[1].cardId, result[1].cardId)
        Assert.assertEquals(cardList[1].name, result[1].name)
        Assert.assertEquals(cardList[1].img, result[1].img)
    }

    @Test
    fun getCardsByType_httpError() {
        setupFail()

        val response = repository.getCardsByType(Types.HERO).test()

        response.assertError(HttpException::class.java)
    }

    @Test
    fun getCardsByFaction_expectedResult() {
        setupSuccess()

        val response = repository.getCardsByFaction(Factions.ALLIANCE).test()
        val result = response.values().first()

        response.assertComplete()
        response.assertNoErrors()
        response.dispose()

        Assert.assertEquals(cardList[0].cardId, result[0].cardId)
        Assert.assertEquals(cardList[0].name, result[0].name)
        Assert.assertEquals(cardList[0].img, result[0].img)
        Assert.assertEquals(cardList[1].cardId, result[1].cardId)
        Assert.assertEquals(cardList[1].name, result[1].name)
        Assert.assertEquals(cardList[1].img, result[1].img)
    }

    @Test
    fun getCardsByFaction_httpError() {
        setupFail()

        val response = repository.getCardsByFaction(Factions.ALLIANCE).test()

        response.assertError(HttpException::class.java)
    }

    @Test
    fun getCardsByQuality_expectedResult() {
        setupSuccess()

        val response = repository.getCardsByQuality(Qualities.RARE).test()
        val result = response.values().first()

        response.assertComplete()
        response.assertNoErrors()
        response.dispose()

        Assert.assertEquals(cardList[0].cardId, result[0].cardId)
        Assert.assertEquals(cardList[0].name, result[0].name)
        Assert.assertEquals(cardList[0].img, result[0].img)
        Assert.assertEquals(cardList[1].cardId, result[1].cardId)
        Assert.assertEquals(cardList[1].name, result[1].name)
        Assert.assertEquals(cardList[1].img, result[1].img)
    }

    @Test
    fun getCardsByQuality_httpError() {
        setupFail()

        val response = repository.getCardsByQuality(Qualities.RARE).test()

        response.assertError(HttpException::class.java)
    }

    @Test
    fun getCardsBySet_expectedResult() {
        setupSuccess()

        val response = repository.getCardsBySet(Sets.TAVERN_BRAWL).test()
        val result = response.values().first()

        response.assertComplete()
        response.assertNoErrors()
        response.dispose()

        Assert.assertEquals(cardList[0].cardId, result[0].cardId)
        Assert.assertEquals(cardList[0].name, result[0].name)
        Assert.assertEquals(cardList[0].img, result[0].img)
        Assert.assertEquals(cardList[1].cardId, result[1].cardId)
        Assert.assertEquals(cardList[1].name, result[1].name)
        Assert.assertEquals(cardList[1].img, result[1].img)
    }

    @Test
    fun getCardsBySet_httpError() {
        setupFail()

        val response = repository.getCardsBySet(Sets.TAVERN_BRAWL).test()

        response.assertError(HttpException::class.java)
    }

    private fun setupSuccess() {
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(getSuccessBody())

        mockWebServer.enqueue(response)
    }

    private fun setupFail() {
        val response = MockResponse()
            .setResponseCode(400)

        mockWebServer.enqueue(response)
    }

    private fun getSuccessBody() : String {
        return Gson().toJson(cardList)
    }
}