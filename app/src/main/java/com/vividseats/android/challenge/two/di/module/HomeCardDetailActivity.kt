package com.vividseats.android.challenge.two.di.module

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.vividseats.android.challenge.two.R
import kotlinx.android.synthetic.main.item_home_card.*

class HomeCardDetailActivity : AppCompatActivity(){

    companion object {
        const val EXTRA_TITLE = "EXTRA_TITLE"
        const val EXTRA_IMAGE = "EXTRA_IMAGE"

        fun getHomeCardDetailIntent(context: Context) : Intent = Intent(context, HomeCardDetailActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_card_details)

        Picasso.get().load(intent.getStringExtra(EXTRA_IMAGE)).fit().into(homeCardImageView)
        topLabelTextView.text = intent.getStringExtra(EXTRA_TITLE)
    }
}
