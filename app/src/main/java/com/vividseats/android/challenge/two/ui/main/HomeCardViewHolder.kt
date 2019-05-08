package com.vividseats.android.challenge.two.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.vividseats.android.challenge.two.data.local.model.HomeCard
import kotlinx.android.synthetic.main.item_home_card.view.*

class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: HomeCard) {
        itemView.titleTextView.text = model.topLabel
//        itemView.subtitleTextView.text = presentationModel.resourceSubtitle
//        itemView.subtitle2TextView.text = itemView.context.getString(R.string.item_subtitle_two)
    }

}