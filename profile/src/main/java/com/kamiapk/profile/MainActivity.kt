package com.kamiapk.profile

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            profileLabelText.text = "名前"
            profileImage.setImageResource(R.drawable.randy_image)
            profileCommentText.text = "Androidメンターのランディだよ"

            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(220,0,100))
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        }
        button2.setOnClickListener {
            profileLabelText.text = "スポーツ"
            profileImage.setImageResource(R.drawable.baseball_image)
            profileCommentText.text = "野球観戦が好きで、スタジアムに通っている"

            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(230,230,0))
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        }
        button3.setOnClickListener {
            profileLabelText.text = "好きな食べ物"
            profileImage.setImageResource(R.drawable.donut_image)
            profileCommentText.text = "キャンディやドーナツ"

            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(255,102,255))
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        }
        button4.setOnClickListener {
            profileLabelText.text = "趣味"
            profileImage.setImageResource(R.drawable.gadget_image)
            profileCommentText.text = "ガジェットを集めて動かすこと"

            button4.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,180,120))
            button1.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button2.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            button3.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        }
    }
}
