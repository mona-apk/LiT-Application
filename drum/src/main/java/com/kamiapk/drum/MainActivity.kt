package com.kamiapk.drum

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var mSoundPool: SoundPool
    private lateinit var mSoundID: Array<Int?>

    private val mSoundResource = arrayOf(
        R.raw.cymbal1,
        R.raw.cymbal2,
        R.raw.cymbal3,
        R.raw.tom1,
        R.raw.tom2,
        R.raw.tom3,
        R.raw.hihat,
        R.raw.snare,
        R.raw.bass
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(mSoundResource.size)
            .build()
        mSoundID = arrayOfNulls(mSoundResource.size)

        for (i in mSoundResource.indices) {
            mSoundID[i] = mSoundPool.load(applicationContext, mSoundResource[i], 0)
        }
    }

    fun cymbal1(v: View) {
        playMusic(0)
    }

    fun cymbal2(v: View) {
        playMusic(1)
    }

    fun cymbal3(v: View) {
        playMusic(2)
    }

    fun tom1(v: View) {
        playMusic(3)
    }

    fun tom2(v: View) {
        playMusic(4)
    }

    fun tom3(v: View) {
        playMusic(5)
    }

    fun hihat(v: View) {
        playMusic(6)
    }

    fun snare(v: View) {
        playMusic(7)
    }

    fun bass(v: View) {
        playMusic(8)
    }

    private fun playMusic(index: Int) {
        if(mSoundID[index] != null) {
            mSoundPool.play(mSoundID[index] as Int, 1f, 1f, 0, 0, 1f)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mSoundPool.release()
    }
}
