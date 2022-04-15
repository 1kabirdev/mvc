package com.mvc.model

import com.google.gson.annotations.SerializedName

class UsersGitHub {

    @SerializedName("login")
    private var login: String = ""

    @SerializedName("avatar_url")
    private var avatarUrl: String = ""

    fun getLogin(): String {
        return login
    }

    fun getAvatarUrl(): String {
        return avatarUrl
    }

}