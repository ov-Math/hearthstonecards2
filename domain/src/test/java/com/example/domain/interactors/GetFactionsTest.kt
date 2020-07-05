package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes
import com.example.domain.model.Factions
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetFactionsTest {

    private val repository : CardsRepository = mockk()
    private val interactor = GetFactions(repository)
    private val factionsList = mutableListOf(Factions.NEUTRAL, Factions.ALLIANCE, Factions.HORDE)

    @Before
    fun setup() {
        every { repository.getFactions() } returns factionsList
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.execute()
        verify { repository.getFactions() }
        Assert.assertEquals(factionsList, result)
    }
}