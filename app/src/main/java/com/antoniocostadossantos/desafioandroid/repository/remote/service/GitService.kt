package com.antoniocostadossantos.desafioandroid.repository.remote.service

import com.antoniocostadossantos.desafioandroid.model.Items
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitService {

    @GET("search/repositories")
    fun getRepositories(
        @Query("q")
        language: String = "kotlin",
        @Query("page")
        page: Int,
        @Query("per_page")
        per_page: Int = 100
    ): Call<Items>
}