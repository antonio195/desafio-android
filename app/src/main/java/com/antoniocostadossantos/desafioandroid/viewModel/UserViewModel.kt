package com.antoniocostadossantos.desafioandroid.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.antoniocostadossantos.desafioandroid.model.Items
import com.antoniocostadossantos.desafioandroid.model.RepositoryModel
import com.antoniocostadossantos.desafioandroid.repository.APIListener
import com.antoniocostadossantos.desafioandroid.repository.UserRepository

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _liveRepo = MutableLiveData<List<RepositoryModel>>()
    val liveRepo: LiveData<List<RepositoryModel>>
        get() = _liveRepo
    private var pageNumber = 1

    init {
        listRepos()
    }

    fun listRepos() {
        repository.getRepositories(pageNumber, object : APIListener<Items> {
            override fun onSucess(result: Items) {
                _liveRepo.postValue(result.items)
            }

            override fun onFailure(message: String) {
                println("Erro UserViewModel - Linha 33")
            }
        })
    }
}