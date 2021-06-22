package com.codingwithmitch.daggerhiltplayground.repository

import com.codingwithmitch.daggerhiltplayground.model.Blog
import com.codingwithmitch.daggerhiltplayground.util.DataState
import com.codingwithmitch.daggerhiltplayground.room.BlogDao
import com.codingwithmitch.daggerhiltplayground.retrofit.BlogRetrofit
import com.codingwithmitch.daggerhiltplayground.retrofit.NetworkMapper
import com.codingwithmitch.daggerhiltplayground.room.CacheMapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try{
            //The network call
            val networkBlogs = blogRetrofit.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)

            //Insert the blogs to the db
            for(blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            //Get the stored blogs from the db
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}