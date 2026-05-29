package com.example.weatherreportapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnStart.setOnClickListener {
            // Start the WeatherActivity
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            // Finish the MainActivity
            finish()
        }
    }
}