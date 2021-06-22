package com.codingwithmitch.daggerhiltplayground.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

//Fragment Factory for MainFactory
class MainFragmentFactory
@Inject
constructor(
    //Pass the dependencies we have for the fragment
    private val someString: String
) : FragmentFactory() {
    //This will be responsible for building the fragment
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
          MainFragment::class.java.name -> {
              //Instantiate the fragment with the dependency
              MainFragment(someString)
          }
            else -> super.instantiate(classLoader, className)
        }
    }
}