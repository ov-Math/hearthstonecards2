package com.example.domain.interactors

import com.example.domain.core.CardsRepository
import com.example.domain.model.Classes
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetClassesTest {

    private val repository : CardsRepository = mockk()
    private val interactor = GetClasses(repository)
    private val classesList = mutableListOf(Classes.DREAM, Classes.WARRIOR)

    @Before
    fun setup() {
        every { repository.getClasses() } returns classesList
    }

    @Test
    fun execute_returnsExpected() {
        val result = interactor.execute()
        verify { repository.getClasses() }
        Assert.assertEquals(classesList, result)
    }
}