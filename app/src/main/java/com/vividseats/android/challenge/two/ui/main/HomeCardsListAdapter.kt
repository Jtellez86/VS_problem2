package com.vividseats.android.challenge.two.ui.main

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vividseats.android.challenge.two.R
import com.vividseats.android.challenge.two.data.local.model.HomeCard
import com.vividseats.android.challenge.two.ui.main.HomeCardsListAdapter.ViewData
import java.util.*
import kotlin.collections.ArrayList

class HomeCardsListAdapter : ListAdapter<ViewData, HomeCardViewHolder>(
        object : DiffUtil.ItemCallback<ViewData>() {
            override fun areItemsTheSame(
                    oldViewData: ViewData,
                    newViewData: ViewData
            ): Boolean =
                    oldViewData.id == newViewData.id

            override fun areContentsTheSame(
                    oldViewData: ViewData,
                    newViewData: ViewData
            ): Boolean =
                    oldViewData.content == newViewData.content

            override fun getChangePayload(
                    oldViewData: ViewData,
                    newViewData: ViewData
            ): Any? = newViewData
        }) {

    data class ViewData(
            val id: Long,
            val content: Any)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        return HomeCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_card, parent, false))
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        holder.bind(getItem(position).content as HomeCard)
    }

    init {
        this.setHasStableIds(true)
    }

    fun submitModels(models: List<HomeCard>) {
        val dataSet = buildDataSet(models)
        super.submitList(dataSet)
    }

    private fun buildDataSet(models: List<HomeCard>): List<ViewData>? {
        val dataSet = ArrayList<ViewData>(models.size)

        if(models.isNotEmpty()){
            models.forEach {model ->
                dataSet.add(ViewData(UUID.randomUUID().leastSignificantBits, model))
            }
        }

        return dataSet
    }
}
