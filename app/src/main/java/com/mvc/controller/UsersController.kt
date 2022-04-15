package com.mvc.controller

import com.mvc.model.UsersGitHub
import com.mvc.services.Api
import com.mvc.services.ServicesGenerator
import com.mvc.view.IUsersView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersController(private var usersView: IUsersView) : IUsersController {

    private val api = ServicesGenerator.createService(Api::class.java)

    override fun OnUsersList() {
        usersView.OnProgress(true)
        api.getUsersGitHub().enqueue(object : Callback<ArrayList<UsersGitHub>> {
            override fun onResponse(
                call: Call<ArrayList<UsersGitHub>>,
                response: Response<ArrayList<UsersGitHub>>
            ) {
                if (response.isSuccessful) {
                    usersView.OnProgress(false)
                    usersView.OnUsersSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<UsersGitHub>>, t: Throwable) {
                usersView.OnUsersError()
                usersView.OnProgress(false)
            }
        })
    }
}