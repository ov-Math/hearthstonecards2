package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.core.exceptions.InvalidFilterException
import com.example.domain.model.CardDomain
import com.example.domain.model.Races
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetCardsByRaceTest {

    private val repository : CardsRepository = mockk()
    lateinit var interactor : GetCardsByRace
    private val cardList = Single.just(listOf(CardDomain("", "", ""), CardDomain("", "", "")))
    val filter = Races.PIRATE

    @Before
    fun setup() {
        every { repository.getCardsByRace(any()) } returns cardList
        interactor = GetCardsByRace(repository)
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.with(filter).execute()
        verify { repository.getCardsByRace(filter) }
        Assert.assertEquals(cardList, result)
    }

    @Test(expected = InvalidFilterException::class)
    fun execute_nullFilter_fail() {
        interactor.execute()
    }
}