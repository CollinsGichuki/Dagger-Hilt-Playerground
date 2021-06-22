package com.codingwithmitch.daggerhiltplayground.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Show Dagger how to build the someString dependency we are injecting in the FragmentFactory
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSOmeString() : String {
        return "Some String"
    }
}