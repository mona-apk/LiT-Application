package com.kamiapk.sound

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val timeReset = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drumSound = MediaPlayer.create(this, R.raw.drum_sound)

        drumImage.setOnClickListener {
            drumSound.seekTo(timeReset)
            drumSound.start()
        }

        drumImage.setOnTouchListener { v, motionEvent ->
            val view = v as ImageView
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                view.setImageResource(R.drawable.drum_playing_image)
                drumSound.seekTo(timeReset)
                drumSound.start()
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                view.setImageResource(R.drawable.drum_image)
            }
            true
        }
    }
}
