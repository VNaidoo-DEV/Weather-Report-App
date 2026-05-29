package com.example.weatherreportapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_views)
        val days = intent.getStringArrayListExtra("days")
        val minTemp = intent.getIntegerArrayListExtra("minTemp")
        val maxTemp = intent.getIntegerArrayListExtra("maxTemp")
        val condition = intent.getStringArrayListExtra("condition")
        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        var display = ""

        if(days != null && minTemp != null && maxTemp != null && condition != null){
            for (i in days.indices) {
                display += "Day: ${days[i]}\n" +
                        "Minimum Temperature: ${minTemp[i]}°C\n" +
                        "Maximum Temperature: ${maxTemp[i]}°C\n" +
                        "Condition: ${condition[i]}\n\n"
            }
        }
        else{
            display = "No data available"
        }
        txtDetails.text = display
        btnBack.setOnClickListener {
            finish()
        }
    }
}