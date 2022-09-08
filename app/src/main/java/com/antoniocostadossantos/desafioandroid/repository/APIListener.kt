package com.antoniocostadossantos.desafioandroid.repository

interface APIListener<T> {
    fun onSucess(result: T)
    fun onFailure(message: String)

}