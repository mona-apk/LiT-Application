package com.monapk.rpg

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.R.layout
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

//え、というか LinearLayout(context)を LinearLayout(context,attributeSet)に変えただけで上手くいくようになったんだけども…?
class LinerTextLayout(context: Context, attributeSet: AttributeSet?) : LinearLayout(context,attributeSet) {

    private var layout : View = LayoutInflater.from(context).inflate(R.layout.liner_text_layout, this)

    private lateinit var translateUp : ObjectAnimator

    private var scrollFrag = false

    //一行に入る文字数と画面に入る文字行数を計算
    /* 共有プリファレンスとかでもいいかも */
    private var letterCount : Int = 0
    private var lineCount : Int = 0
    private var textHeight = 0

    //ms,現実では許攸プリファレンスあたりでいじることも視野に入れる
    private var textInterval : Long = 700L

    //画面にViewが描写された後に各種の計算
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if( textHeight == 0){
            //onWindowFocusChangedがバックグラウンドでよばれるとクラッシュするので初めの一回だけ表示されるようにする
            letterCount = this.width / layout.measureText.width
            textHeight = layout.measureText.height
            lineCount = this.height / textHeight
            layout.linerTextLayout.removeViewAt(0)
        }
    }

    //ここでmsを返すことができたらかっこよくない?
    fun textScroll(text : String) {

        //文字列をTextViewのリストに変換
        var textViewList = getTextView(text)

        //LinerLayoutに複数行追加

        CoroutineScope(Main).launch {
            for( i in textViewList) {
                //linerlayoutにtextviewを追加する
                layout.linerTextLayout.addView(i)
                val size = layout.linerTextLayout.childCount
                //スクロールするかしないか
                //ここの条件をもう少し考えることができそう
                if (!scrollFrag) {
                    Log.d("TAGG",layout.linerTextLayout.size.toString())
                    if (layout.linerTextLayout.size >= lineCount -1 ) {
                        scrollFrag = true
                    }

                } else {
                    //linerlayout全体を上に動かす
                    val height = textHeight.toFloat()
                    translateUp =
                        ObjectAnimator.ofFloat(layout.linerTextLayout, "translationY", 0F, -height)
                    translateUp.apply {
                        duration = 700
                        start()
                    }

                    //linerlayoutの移動をリセットする
                    layout.linerTextLayout.removeViewAt(0)
                    translateUp = ObjectAnimator.ofFloat(layout.linerTextLayout, "translationY", 0F, 0F)
                    translateUp.apply {
                        duration = 0
                        start()
                    }

                }

                delay(textInterval + 10)
            }
            delay(textInterval)
        }
        Log.d("TAGG","Hi!")
    }

    //stringを引き取り、textViewの配列を返す
    private fun getTextView(text : String): ArrayList<TextView> {
        var textSplit = text.split("\n")
        var textLength = textSplit[0].length

        //textviewのリスト
        val listTextView : ArrayList<TextView> = ArrayList()
        //stringのリスト
        val listString : ArrayList<String> = ArrayList()

        for( textSplit in textSplit){

            var text = textSplit
            textLength = text.length

            while(textLength > letterCount){
                val subText = text.substring(0,letterCount)
                text = text.substring(letterCount,textLength)
                textLength = text.length
                listString.add(subText)
            }
            listString.add(text)
        }

        //listStringをもとにTextViewを作っていく
        for(j in listString){
            val textView = TextView(context)
            textView.text = j
            //TODO:ここの情報はLinerTextLayoutができる時に外部から情報を取り寄せたい
            textView.textSize = 16f
            //TODO:結局これいるの?
            //textView.layoutParams = layoutParams
            listTextView.add(textView)
        }
        return listTextView
    }

}