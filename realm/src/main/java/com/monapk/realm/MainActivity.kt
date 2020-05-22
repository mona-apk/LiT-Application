package com.monapk.realm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memo: Memo? = read()

        if (memo != null) {
            titleET.setText(memo.title)
            contentET.setText(memo.content)
        }

        saveButton.setOnClickListener {
            val title: String = titleET.text.toString()
            val content: String = contentET.text.toString()
            save(title, content)
        }
    }

    fun read(): Memo? {
        return realm.where(Memo::class.java).findFirst()
    }

    fun save(title: String, content: String) {
        val memo: Memo? = read()

        realm.executeTransaction {
            if (memo != null) {
                memo.title = title
                memo.content = content
            } else {
                val newMemo: Memo = it.createObject(Memo::class.java)
                newMemo.title = title
                newMemo.content = content
            }

            Snackbar.make(container, "保存しました!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
