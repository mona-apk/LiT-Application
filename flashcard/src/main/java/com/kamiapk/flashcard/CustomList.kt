package com.kamiapk.flashcard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kamiapk.flashcard.model.Word
import kotlinx.android.synthetic.main.list_item.view.*

class CustomList : View {

    constructor(context: Context, viewGroup: ViewGroup, word: Word) : super(context) {
        init(null, 0, viewGroup, word)
    }

    constructor(context: Context, attrs: AttributeSet, viewGroup: ViewGroup, word: Word) : super(
        context,
        attrs
    ) {
        init(null, 0, viewGroup, word)
    }

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int,
        viewGroup: ViewGroup,
        word: Word
    ) : super(
        context,
        attrs,
        defStyle
    ) {
        init(null, 0, viewGroup, word)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int, viewGroup: ViewGroup, word: Word) {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup)
        //TODO:layoutへの操作
    }
}
