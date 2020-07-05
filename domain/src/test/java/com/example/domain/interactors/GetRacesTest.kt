package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes
import com.example.domain.model.Races
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetRacesTest {

    private val repository : CardsRepository = mockk()
    private val interactor = GetRaces(repository)
    private val racesList = mutableListOf(Races.TOTEM, Races.PIRATE)

    @Before
    fun setup() {
        every { repository.getRaces() } returns racesList
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.execute()
        verify { repository.getRaces() }
        Assert.assertEquals(racesList, result)
    }
}