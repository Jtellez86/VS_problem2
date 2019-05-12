package com.vividseats.android.challenge.two.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import com.vividseats.android.challenge.two.data.local.model.HomeCard
import com.vividseats.android.challenge.two.di.module.HomeCardDetailActivity
import kotlinx.android.synthetic.main.item_home_card.view.*

class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: HomeCard) {
        Picasso.get().load(model.image).fit().into(itemView.homeCardImageView)
        itemView.topLabelTextView.text = model.topLabel
        itemView.middleLabelTextView.text =  model.middleLabel
        itemView.dateLabelTextView.text = model.bottomLabel

        itemView.setOnClickListener {
            val intent = HomeCardDetailActivity.getHomeCardDetailIntent(itemView.context)
            intent.putExtra(HomeCardDetailActivity.EXTRA_TITLE, model.topLabel)
            intent.putExtra(HomeCardDetailActivity.EXTRA_IMAGE, model.image)

            itemView.context.startActivity(intent)
        }
    }

}