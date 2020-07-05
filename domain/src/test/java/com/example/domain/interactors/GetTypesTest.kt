package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes
import com.example.domain.model.Types
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetTypesTest {

    private val repository : CardsRepository = mockk()
    private val interactor = GetTypes(repository)
    private val typesList = mutableListOf(Types.HERO_POWER, Types.HERO)

    @Before
    fun setup() {
        every { repository.getTypes() } returns typesList
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.execute()
        verify { repository.getTypes() }
        Assert.assertEquals(typesList, result)
    }
}