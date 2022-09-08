package com.antoniocostadossantos.desafioandroid.model

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("items")
    val items: List<RepositoryModel>
)