package com.kamiapk.count

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

//Activityは画面
class MainActivity : AppCompatActivity() {

    private var count: Int = 0;

    private val plus: Int = 1
    private val minus: Int = -1
    private val clear: Int = 0

    private val keywordList: List<String> = listOf("apple", "banana", "cat", "dog")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //import kotlinx.android.synthetic.main.activity_main.*とセット
        setContentView(R.layout.activity_main)

        countTextView.text = "$count"
        countTextView.setTextColor(Color.GRAY)

        plusButton.setOnClickListener {
            changeCount(plus)
        }

        minusButton.setOnClickListener {
            changeCount(minus)
        }

        clearButton.setOnClickListener {
            changeCount(clear)
        }
    }

    private fun changeCount(countOperator: Int) {

        if (countOperator != 0) {
            count += countOperator
            when {
                count % 15 == 0 -> {
                    countTextView.setTextColor(Color.RED)
                }
                count % 3 == 0 -> {
                    countTextView.setTextColor(Color.GREEN)
                }
                count % 5 == 0 -> {
                    countTextView.setTextColor(Color.BLUE)
                }
                else -> {
                    countTextView.setTextColor(Color.GRAY)
                }
            }
        } else {
            count = 0
            countTextView.setTextColor(Color.GRAY)
        }
        countTextView.text = "$count"

        if( keywordList.elementAtOrNull(count) == null) {
            keywordTextView.text = "その番号のキーワードは存在しません"
        } else {
            keywordTextView.text= keywordList[count]
        }
    }
}
