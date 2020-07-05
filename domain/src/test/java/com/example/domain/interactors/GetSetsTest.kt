package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes
import com.example.domain.model.Sets
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetSetsTest {

    private val repository : CardsRepository = mockk()
    private val interactor = GetSets(repository)
    private val setsList = mutableListOf(Sets.GRAND_TOURNAMENT, Sets.TAVERN_BRAWL)

    @Before
    fun setup() {
        every { repository.getSets() } returns setsList
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.execute()
        verify { repository.getSets() }
        Assert.assertEquals(setsList, result)
    }
}