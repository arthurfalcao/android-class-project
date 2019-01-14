package br.com.rogalabs.postsapi.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.rogalabs.postsapi.R

class ListPostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_posts)
        val message = findViewById<TextView>(R.id.note_list_textview)
        message.text = "Welcome"
    }
}
