package com.vividseats.android.challenge.two.ui.main


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vividseats.android.challenge.two.R
import com.vividseats.android.challenge.two.ui.util.observeNonNull
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity()/*, HasSupportFragmentInjector*/ {
//    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.presentationData.observeNonNull(this) {presentation ->
            //populate cards with data

        }

        viewModel.bind()
    }

//    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}