package com.vividseats.android.challenge.two.ui.main


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.vividseats.android.challenge.two.R
import com.vividseats.android.challenge.two.ui.decoration.OffsetItemDecoration
import com.vividseats.android.challenge.two.ui.util.observeNonNull
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var listAdapter: HomeCardsListAdapter
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        rootView.setBackgroundColor(ContextCompat.getColor(this, R.color.window_background_cards))

        recyclerView.apply {
            addItemDecoration(
                    OffsetItemDecoration(
                            resources.getDimensionPixelSize(R.dimen.spacing_small),
                            resources.getDimensionPixelSize(R.dimen.spacing_small),
                            resources.getDimensionPixelSize(R.dimen.spacing_medium),
                            resources.getDimensionPixelSize(R.dimen.spacing_medium)
                    )
            )
            adapter = listAdapter
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.presentationData.observeNonNull(this) { presentation ->
            listAdapter.submitModels(presentation.homeCards!!)
        }

        viewModel.getHomeCards()
    }
}