package com.mvc.services

import com.mvc.model.UsersGitHub
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("users")
    fun getUsersGitHub(): Call<ArrayList<UsersGitHub>>
}