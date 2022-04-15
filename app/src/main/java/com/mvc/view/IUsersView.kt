package com.mvc.view

import com.mvc.model.UsersGitHub

interface IUsersView {
    fun OnUsersSuccess(list: ArrayList<UsersGitHub>)
    fun OnUsersError()
    fun OnProgress(show: Boolean)
}