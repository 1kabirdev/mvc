package com.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mvc.adapter.UsersAdapter
import com.mvc.controller.IUsersController
import com.mvc.controller.UsersController
import com.mvc.model.UsersGitHub
import com.mvc.view.IUsersView

class MainActivity : AppCompatActivity(), IUsersView {

    private var usersController: IUsersController? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progress = findViewById(R.id.progress)

        usersController = UsersController(this)
        (usersController as UsersController).OnUsersList()
    }

    override fun OnUsersSuccess(list: ArrayList<UsersGitHub>) {
        val adapter = UsersAdapter(list)
        recyclerView.adapter = adapter
    }

    override fun OnUsersError() {
        Toast.makeText(this, "Проверьте подключение интернета", Toast.LENGTH_SHORT).show()
    }

    override fun OnProgress(show: Boolean) {
        if (show) {
            progress.visibility = View.VISIBLE
        } else {
            progress.visibility = View.GONE
        }
    }
}