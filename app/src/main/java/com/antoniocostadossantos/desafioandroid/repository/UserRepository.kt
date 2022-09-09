package com.antoniocostadossantos.desafioandroid.repository

import com.antoniocostadossantos.desafioandroid.repository.remote.RetrofitInstance
import com.antoniocostadossantos.desafioandroid.repository.remote.service.GitService
import com.antoniocostadossantos.desafioandroid.model.Items
import com.antoniocostadossantos.desafioandroid.repository.mock.FakeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository() : BaseRepository() {

    private val remote = RetrofitInstance.getService(GitService::class.java)

    fun getRepositories(
        pageNumber: Int,
        listener: APIListener<Items>,
    ) {
        remote.getRepositories("kotlin", pageNumber)
            .enqueue(object : Callback<Items> {
                override fun onResponse(call: Call<Items>, response: Response<Items>) {
                    handleResponse(response, listener)
                }

                override fun onFailure(call: Call<Items>, t: Throwable) {
                    println("Erro UserRepository - Linha 28")
                }

            })
    }
}