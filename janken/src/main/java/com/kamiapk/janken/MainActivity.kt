package com.kamiapk.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val handsList = listOf(R.drawable.goo, R.drawable.choki, R.drawable.paa)

    private val goo = 0
    private val choki = 1
    private val paa = 2

    private var winCount = 0
    private var loseCount = 0
    private var drawCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gooButton.setOnClickListener {
            gameStart(goo)
        }
        chokiButton.setOnClickListener {
            gameStart(choki)
        }
        paaButton.setOnClickListener {
            gameStart(paa)
        }
    }

    private fun gameStart(playerHand: Int) {
        val cpuHand = Random.nextInt(handsList.size)

        playerHandIV.setImageResource(handsList[playerHand])
        cpuHandIV.setImageResource(handsList[cpuHand])

        when ((playerHand - cpuHand + 3) % 3) {
            0 -> {
                gameTV.text = "引き分け!"
                drawCount++
            }
            1 -> {
                gameTV.text = "負け!"
                loseCount++
            }
            2 -> {
                gameTV.text = "勝ち!"
                winCount++
            }
        }

        resultTV.text = "${winCount}勝  ${loseCount}負 ${drawCount}分"
    }
}
