package com.dicoding.salsahava.livedatawithapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dicoding.salsahava.livedatawithapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.hide()

        mainViewModel.restaurant.observe(this, { restaurant ->
            activityMainBinding.apply {
                tvTitle.text = restaurant.name
                tvDescription.text = restaurant.description

                Glide.with(this@MainActivity)
                    .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
                    .into(ivPicture)
            }
        })

        mainViewModel.listReview.observe(this, { consumerReviews ->
            val listReview = consumerReviews.map {
                "${it.review}\n- ${it.name}"
            }

            activityMainBinding.apply {
                lvReview.adapter = ArrayAdapter(this@MainActivity, R.layout.item_review, listReview)
                edReview.setText("")
            }
        })

        mainViewModel.isLoading.observe(this, {
            activityMainBinding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        activityMainBinding.btnSend.setOnClickListener { view ->
            mainViewModel.postReview(activityMainBinding.edReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}