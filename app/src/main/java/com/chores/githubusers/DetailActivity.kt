package com.chores.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = getSupportActionBar()
        actionBar!!.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showUserDetail()
    }

    private fun showUserDetail() {
        val tvImage: ImageView = findViewById(R.id.iv_detail_user)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvUsername: TextView = findViewById(R.id.tv_detail_username)
        val tvLocation : TextView = findViewById(R.id.tv_detail_location)
        val tvCompany: TextView = findViewById(R.id.tv_detail_company)
        val tvFollowers: TextView = findViewById(R.id.tv_detail_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_detail_following)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        user.avatar?.let { tvImage.setImageResource(it) }
        tvName.text = "${user.name}"
        tvUsername.text = "${user.username}"
        tvLocation.text = "${user.location}"
        tvCompany.text = "${user.company}"
        tvFollowers.text = "${user.followers}"
        tvFollowing.text = "${user.following}"
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}