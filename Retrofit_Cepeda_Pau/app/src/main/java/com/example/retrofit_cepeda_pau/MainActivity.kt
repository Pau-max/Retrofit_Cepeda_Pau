package com.example.retrofit_cepeda_pau

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAct1).setOnClickListener {
            startActivity(Intent(this, Act1Activity::class.java))
        }
        findViewById<Button>(R.id.btnAct2).setOnClickListener {
            startActivity(Intent(this, Act2Activity::class.java))
        }
    }
}