package com.monapk.rpg

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.view.size

import kotlinx.android.synthetic.main.liner_text_layout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LinerTextLayout(context: Context, attributeSet: AttributeSet?) :
    LinearLayout(context, attributeSet) {

    private var layout: View =
        LayoutInflater.from(context).inflate(R.layout.liner_text_layout, this)

    private lateinit var translateUp: ObjectAnimator

    private var scrollFrag = false

    private var letterCount: Int = 0
    private var lineCount: Int = 0
    private var textHeight = 0

    private var textInterval: Long = 700L

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (textHeight == 0) {
            letterCount = this.width / layout.measureText.width
            textHeight = layout.measureText.height
            lineCount = this.height / textHeight
            layout.linerTextLayout.removeViewAt(0)
        }
    }

    fun textScroll(text: String) {

        val textViewList = getTextView(text)

        CoroutineScope(Main).launch {
            for (i in textViewList) {

                layout.linerTextLayout.addView(i)
                val size = layout.linerTextLayout.childCount

                if (!scrollFrag) {
                    Log.d("TAGG", layout.linerTextLayout.size.toString())
                    if (layout.linerTextLayout.size >= lineCount - 1) {
                        scrollFrag = true
                    }

                } else {
                    val height = textHeight.toFloat()
                    translateUp =
                        ObjectAnimator.ofFloat(layout.linerTextLayout, "translationY", 0F, -height)
                    translateUp.apply {
                        duration = 700
                        start()
                    }

                    layout.linerTextLayout.removeViewAt(0)
                    translateUp =
                        ObjectAnimator.ofFloat(layout.linerTextLayout, "translationY", 0F, 0F)
                    translateUp.apply {
                        duration = 0
                        start()
                    }

                }

                delay(textInterval + 10)
            }
            delay(textInterval)
        }
    }

    private fun getTextView(text: String): ArrayList<TextView> {
        val textSplit = text.split("\n")
        var textLength = textSplit[0].length

        val listTextView: ArrayList<TextView> = ArrayList()
        val listString: ArrayList<String> = ArrayList()

        for (textSplit in textSplit) {

            var text = textSplit
            textLength = text.length

            while (textLength > letterCount) {
                val subText = text.substring(0, letterCount)
                text = text.substring(letterCount, textLength)
                textLength = text.length
                listString.add(subText)
            }
            listString.add(text)
        }

        for (j in listString) {
            val textView = TextView(context)
            textView.text = j
            textView.textSize = 16f
            //TODO:結局これいるの?
            //textView.layoutParams = layoutParams
            listTextView.add(textView)
        }
        return listTextView
    }

}