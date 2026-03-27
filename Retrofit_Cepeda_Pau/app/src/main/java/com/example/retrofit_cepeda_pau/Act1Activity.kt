package com.example.retrofit_cepeda_pau
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class Act1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act1)

        val rv = findViewById<RecyclerView>(R.id.rvPosts)
        rv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnLoad).setOnClickListener {
            lifecycleScope.launch {
                try {
                    val posts = RetrofitClient.api.getPosts()
                    rv.adapter = PostAdapter(posts)
                } catch (e: Exception) { e.printStackTrace() }
            }
        }
    }
}
