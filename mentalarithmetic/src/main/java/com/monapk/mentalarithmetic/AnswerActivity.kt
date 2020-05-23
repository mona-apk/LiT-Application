package com.monapk.mentalarithmetic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val displayQuestion = intent.getStringExtra("question")
        val yourAnswer = intent.getStringExtra("answer")
        val correctAnswer = intent.getStringExtra("correct")

        questionTV.text = displayQuestion
        yourAnswerTV.text = yourAnswer

        if (yourAnswer == correctAnswer) {
            markIV.setImageResource(R.drawable.correct_image)
            randyIV.setImageResource(R.drawable.randy_happy_image)
        } else {
            markIV.setImageResource(R.drawable.miss_image)
            randyIV.setImageResource(R.drawable.randy_sad_image)
        }

        backButton.setOnClickListener {
            val questionPage = Intent(this, MainActivity::class.java)
            startActivity(questionPage)
            finish()
        }
    }
}
