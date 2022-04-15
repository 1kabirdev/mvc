package com.mvc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mvc.R
import com.mvc.model.UsersGitHub
import com.squareup.picasso.Picasso

class UsersAdapter(private var users: ArrayList<UsersGitHub>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private lateinit var viewHolder: ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        viewHolder.bind(holder, users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView: ImageView = view.findViewById(R.id.imageview)
        private val name: TextView = view.findViewById(R.id.name)

        fun bind(holder: ViewHolder, usersGitHub: UsersGitHub) {
            Picasso.get().load(usersGitHub.getAvatarUrl()).into(holder.imageView)
            holder.name.text = usersGitHub.getLogin()
        }
    }
}

