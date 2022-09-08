package com.antoniocostadossantos.desafioandroid.dependency

import com.antoniocostadossantos.desafioandroid.repository.UserRepository
import com.antoniocostadossantos.desafioandroid.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single {
        UserRepository()
    }

    viewModel {
        UserViewModel(
            repository = get()
        )
    }
}