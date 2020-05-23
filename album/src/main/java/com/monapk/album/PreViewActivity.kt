package com.monapk.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pre_view.*

class PreViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_view)

        val imageId = intent.getIntExtra("image", 0)
        val displayTitle = intent.getStringExtra("title")
        preViewIV.setImageResource(imageId)
        titleTV.text = displayTitle

        backButton.setOnClickListener {
            finish()
        }
    }
}
