package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes
import com.example.domain.model.Qualities
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetQualitiesTest {

    private val repository : CardsRepository = mockk()
    private val interactor = GetQualities(repository)
    private val qualitiesList = mutableListOf(Qualities.LEGENDARY, Qualities.RARE)

    @Before
    fun setup() {
        every { repository.getQualities() } returns qualitiesList
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.execute()
        verify { repository.getQualities() }
        Assert.assertEquals(qualitiesList, result)
    }
}