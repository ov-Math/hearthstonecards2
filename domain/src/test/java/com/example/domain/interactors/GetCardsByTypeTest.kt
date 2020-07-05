package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.core.exceptions.InvalidFilterException
import com.example.domain.model.CardDomain
import com.example.domain.model.Types
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
class GetCardsByTypeTest {

    private val repository : CardsRepository = mockk()
    lateinit var interactor : GetCardsByType
    private val cardList = Single.just(listOf(CardDomain("", "", ""), CardDomain("", "", "")))
    val filter = Types.HERO

    @Before
    fun setup() {
        every { repository.getCardsByType(any()) } returns cardList
        interactor = GetCardsByType(repository)
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.with(filter).execute()
        verify { repository.getCardsByType(filter) }
        Assert.assertEquals(cardList, result)
    }

    @Test(expected = InvalidFilterException::class)
    fun execute_nullFilter_fail() {
        interactor.execute()
    }
}