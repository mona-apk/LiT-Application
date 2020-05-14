package com.kamiapk.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var second: Int = 10

    val timer: CountDownTimer = object : CountDownTimer(10000,1000) {
        override fun onFinish() {
            button.isVisible = true
            second = 10
            secondText.text = second.toString()
            Toast.makeText(applicationContext , "タイマーが終了しました.", Toast.LENGTH_SHORT).show();
        }

        override fun onTick(p0: Long) {
            second-=1
            secondText.text = second.toString()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Toast.makeText(applicationContext , "カウントダウンを始めます.", Toast.LENGTH_SHORT).show();
            button.isVisible = false
            timer.start()
        }
    }
}
