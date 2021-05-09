package com.dicoding.salsahava.myidlingresource

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

// For testing purposes, should be deleted if the app will be turned into APK
object EspressoIdlingResource {

    private val RESOURCE: String? = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResource(): IdlingResource {
        return espressoTestIdlingResource
    }
}