package com.monapk.rpg

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val Text = arrayOf(
    "aaa",
    "ate",
    "テストテストテスト",
    "むかしむかし、あるところに、おじいさんとおばあさんが住んでいました。",
    "おじいさんは山へしばかりに、おばあさんは川へせんたくに行きました。",
    "おばあさんが川でせんたくをしていると、ドンブラコ、ドンブラコと、大きな桃が流れてきました。",
    "「おや、これは良いおみやげになるわ」\n" +
            "　おばあさんは大きな桃をひろいあげて、家に持ち帰りました。",
    "「そして、おじいさんとおばあさんが桃を食べようと桃を切ってみると、なんと中から元気の良い男の赤ちゃんが飛び出してきました。",
    "「これはきっと、神さまがくださったにちがいない」\n" +
            "　子どものいなかったおじいさんとおばあさんは、大喜びです。",
    "「桃から生まれた男の子を、おじいさんとおばあさんは桃太郎と名付けました。",
    "桃太郎はスクスク育って、やがて強い男の子になりました。",
    ""
)

class MainActivity : ScopedAppActivity() {

    private val layoutParams = ViewGroup.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )

    private lateinit var translateUp: ObjectAnimator
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                liner_text_layouts.textScroll("あああああああああああああああああああああああああああああ")
                fadeButton(it)
            }
        }
    }

    private fun fadeButton(view: View) {
        launch {
            fadeoutAnimation(view)
            delay(700)
            fadeInAnimation(view)
            isRunning = false
        }
    }

    private fun fadeoutAnimation(view: View) {
        val fadeObjectAnimator = ObjectAnimator.ofFloat(button, "alpha", 1.0f, 0.0f)
        fadeObjectAnimator?.apply {
            duration = 300
            start()
        }
    }

    private fun fadeInAnimation(view: View) {
        val fadeObjectAnimator = ObjectAnimator.ofFloat(button, "alpha", 0.0f, 1.0f)
        fadeObjectAnimator?.apply {
            duration = 300
            start()
        }
    }
}
