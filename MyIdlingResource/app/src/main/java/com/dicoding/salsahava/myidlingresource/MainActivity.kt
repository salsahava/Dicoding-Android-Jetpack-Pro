package com.dicoding.salsahava.myidlingresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dicoding.salsahava.myidlingresource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.button.setOnClickListener {
            delay1()
            delay2()
        }
    }

    private fun delay1() {
        // For testing purposes, should be deleted if the app will be turned into APK
        EspressoIdlingResource.increment()

        Handler(Looper.getMainLooper()).postDelayed({
            activityMainBinding.textView.text = getString(R.string.delay1)

            // For testing purposes, should be deleted if the app will be turned into APK
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                // Memberitahukan bahwa tugas sudah selesai dijalankan
                EspressoIdlingResource.decrement()
            }
        }, 2000)
    }

    private fun delay2() {
        // For testing purposes, should be deleted if the app will be turned into APK
        EspressoIdlingResource.increment()

        Handler(Looper.getMainLooper()).postDelayed({
            activityMainBinding.textView.text = getString(R.string.delay2)

            // For testing purposes, should be deleted if the app will be turned into APK
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                // Memberitahukan bahwa tugas sudah selesai dijalankan
                EspressoIdlingResource.decrement()
            }
        }, 3000)
    }
}