package com.kamiapk.primequize

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val maxProblems = 10
    private var problemsNumber = 10
    private var displayNumber = 0
    private var ansNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        restart()

        isPrimeBtn.setOnClickListener {
            answerLIV.visibility = View.VISIBLE
            if (isPrimeNumber(displayNumber)) {
                answerLIV.setAnimation(R.raw.correct)
                ansNumber++
            } else {
                answerLIV.setAnimation(R.raw.incorrect)
            }
            answerLIV.playAnimation()
            next()
        }

        notPrimeBtn.setOnClickListener {
            answerLIV.visibility = View.VISIBLE
            if (!isPrimeNumber(displayNumber)) {
                answerLIV.setAnimation(R.raw.correct)
                ansNumber++
            } else {
                answerLIV.setAnimation(R.raw.incorrect)
            }
            answerLIV.playAnimation()
            next()
        }

        restartButton.setOnClickListener {
            restart()
        }

        endButton.setOnClickListener {
            endGame()
        }

        resultLayout.setOnTouchListener { _, _ -> true }
    }

    private fun restart() {
        answerLIV.visibility = View.GONE
        problemsNumber = maxProblems
        viewChange()
        ansNumber = 0
        resultLayout.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    private fun next() {
        problemsNumber--
        viewChange()
        if (problemsNumber <= 0) {
            resultLayout.visibility = View.VISIBLE
            ansTV.text = "${ansNumber}問正解!"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun viewChange() {
        textView5.text = "残り: ${problemsNumber}問"
        displayNumber = Random.nextInt(500)
        primeTV.text = displayNumber.toString()
    }

    private fun isPrimeNumber(number: Int): Boolean {
        val limitNum = (sqrt(number.toFloat()) + 1).toInt()
        for (i in 2..limitNum) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    private fun endGame() {
        finish()
    }
}
