package com.chores.githubusers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv_list: RecyclerView
    private var list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list = findViewById(R.id.rv_list_user)
        rv_list.setHasFixedSize(true)
        list.addAll(listUser)

        showRecyclerList()
    }

    private val listUser: java.util.ArrayList<User>
        get() {
            val Name = resources.getStringArray(R.array.name)
            val Username = resources.getStringArray(R.array.username)
            val Location = resources.getStringArray(R.array.location)
            val Company = resources.getStringArray(R.array.company)
            val Followers = resources.getStringArray(R.array.followers)
            val Following = resources.getStringArray(R.array.following)
            val Image = resources.obtainTypedArray(R.array.avatar)
            Image.recycle()
            val listUser = java.util.ArrayList<User>()
            for (i in Name.indices) {
                val user = User(
                    Name[i],
                    Username[i],
                    Location[i],
                    Company[i],
                    Followers[i],
                    Following[i],
                    Image.getResourceId(i, -1)
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rv_list.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListAdapter(list)
        rv_list.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val dataUser = User(
                    data.name,
                    data.username,
                    data.location,
                    data.company,
                    data.following,
                    data.followers,
                    data.avatar
                )
                val detailUserActivity = Intent(this@MainActivity, DetailActivity::class.java)
                detailUserActivity.putExtra(DetailActivity.EXTRA_USER, dataUser)
                startActivity(detailUserActivity)
            }
        })
    }

}