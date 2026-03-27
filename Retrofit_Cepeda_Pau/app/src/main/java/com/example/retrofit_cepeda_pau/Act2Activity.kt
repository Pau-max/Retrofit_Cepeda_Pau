package com.example.retrofit_cepeda_pau

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class Act2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2)

        val et = findViewById<EditText>(R.id.etId)
        val tv = findViewById<TextView>(R.id.tvPostContent)
        val rv = findViewById<RecyclerView>(R.id.rvComments)
        rv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnSearch).setOnClickListener {
            val id = et.text.toString().toIntOrNull() ?: return@setOnClickListener
            lifecycleScope.launch {
                try {
                    val post = RetrofitClient.api.getPostById(id)
                    val comments = RetrofitClient.api.getComments(id)

                    tv.text = "POST #${post.id}\n${post.title.uppercase()}\n\n${post.body}"
                    rv.adapter = CommentAdapter(comments)
                } catch (e: Exception) {
                    Toast.makeText(this@Act2Activity, "No s'ha trobat el post", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}