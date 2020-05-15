package com.kamiapk.curry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val animals = arrayOf("いのしし","ごりら","にわとり","きつね")
    private val foods = arrayOf("カレー","ナンカレー","インドカレー","チキンカレー")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            game()
        }
    }

    private fun game() {
        val animalIndex1 = Random.nextInt(animals.size)
        var animalIndex2 = Random.nextInt(animals.size)
        val foodIndex = Random.nextInt(foods.size)

        while (animalIndex1 == animalIndex2) {
            animalIndex2 = Random.nextInt(animals.size)
        }

        textView.text = "${animals[animalIndex1]}は"
        textView2.text = "${animals[animalIndex2]}に"
        val result = if( (Random.nextInt(100) + 1) >= 50) {
            "をよそえました!"
        } else {
            "をよそえませんでした"
        }
        textView3.text = "${foods[foodIndex]}を$result"
    }
}
