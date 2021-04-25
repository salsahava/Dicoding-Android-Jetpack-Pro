package com.dicoding.salsahava.myunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        viewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)

        val circumference = viewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)

        val surfaceArea = viewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)

        val volume = viewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when`(viewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = viewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun testMockCircumference() {
        `when`(viewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = viewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when`(viewModel.getVolume()).thenReturn(dummyVolume)
        val volume = viewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
}