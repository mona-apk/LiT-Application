package com.monapk.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val data: List<Data> = listOf(
        Data(R.drawable.one, "1", "一"),
        Data(R.drawable.two, "2", "二"),
        Data(R.drawable.three, "3", "三"),
        Data(R.drawable.four, "4", "四"),
        Data(R.drawable.five, "5", "五"),
        Data(R.drawable.six, "6", "六"),
        Data(R.drawable.seven, "7", "七"),
        Data(R.drawable.eight, "8", "八"),
        Data(R.drawable.nine, "9", "九")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecyclerViewAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        //Divider
        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )

        recyclerView.apply {
            this.layoutManager = layoutManager
            addItemDecoration(mDividerItemDecoration)
            this.adapter = adapter
        }
        adapter.addAll(data)
    }
}
