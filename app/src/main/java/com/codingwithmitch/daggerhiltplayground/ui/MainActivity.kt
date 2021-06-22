package com.codingwithmitch.daggerhiltplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.daggerhiltplayground.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //Transact to the fragment
//        supportFragmentManager.fragmentFactory = fragmentFactory
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_fragment_container, MainFragment::class.java, null)
//            .commit()

    }

}



















