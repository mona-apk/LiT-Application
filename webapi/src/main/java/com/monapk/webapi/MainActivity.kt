package com.monapk.webapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import coil.api.load
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson: Gson =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val userService: UserService = retrofit.create(UserService::class.java)

        requestButton.setOnClickListener {
            runBlocking(Dispatchers.IO) {
                runCatching {
                    userService.getUser("mona-apk")
                }
            }.onSuccess {
                card.visibility = View.VISIBLE
                avatarIV.load(it.avatarUrl)
                nameTV.text = it.name
                userIdTV.text = it.userId
                followingTV.text = "Following: " + it.following.toString()
                followersTV.text = "Followers: " + it.followers.toString()
            }.onFailure {
                Log.d("tags", it.toString())
            }
        }
    }

}
