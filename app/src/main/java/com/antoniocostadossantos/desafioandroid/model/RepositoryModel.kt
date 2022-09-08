package com.antoniocostadossantos.desafioandroid.model

import com.google.gson.annotations.SerializedName

data class RepositoryModel(
    @SerializedName("forks_count")
    val forks_count: Int,

    @SerializedName("html_url")
    val html_url: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("stargazers_count")
    val stargazers_count: Int,

    @SerializedName("owner")
    val owner: Owner

)