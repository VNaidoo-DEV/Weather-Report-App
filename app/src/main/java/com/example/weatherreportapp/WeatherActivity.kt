package com.example.weatherreportapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WeatherActivity : AppCompatActivity() {
    //Arrays
    private val days = ArrayList<String>()
    private val minTemp = ArrayList<Int>()
    private val maxTemp = ArrayList<Int>()
    private val condition = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)

        val txtDay = findViewById<EditText>(R.id.txtDay)
        val txtMinTemp = findViewById<EditText>(R.id.txtMinTemp)
        val txtMaxTemp = findViewById<EditText>(R.id.txtMaxTemp)
        val txtCondition = findViewById<EditText>(R.id.txtCondition)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)

        btnAdd.setOnClickListener {
            val day = txtDay.text.toString()
            val min = txtMinTemp.text.toString()
            val max = txtMaxTemp.text.toString()
            val cond = txtCondition.text.toString()
            if (day.isEmpty() || min.isEmpty() || max.isEmpty() || cond.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter all fields",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                minTemp.add(min.toInt())
                maxTemp.add(max.toInt())
                days.add(day)
                condition.add(cond)
                txtAverage.text = "DATA ADDED SUCCESSFULLY"
                // Clear fields
                txtDay.text.clear()
                txtMinTemp.text.clear()
                txtMaxTemp.text.clear()
                txtCondition.text.clear()


            }
            btnCalculate.setOnClickListener {
                btnCalculate.setOnClickListener {

                    if (minTemp.isEmpty() || maxTemp.isEmpty()) {

                        txtAverage.text = "No data entered"

                    } else {

                        var totalMin = 0
                        var totalMax = 0

                        // Loop through all temperatures
                        for (i in minTemp.indices) {

                            totalMin += minTemp[i]
                            totalMax += maxTemp[i]
                        }

                        // Calculate averages
                        val averageMin = totalMin / minTemp.size
                        val averageMax = totalMax / maxTemp.size

                        txtAverage.text =
                            "Average Minimum Temperature: ${averageMin}°C\n" +
                                    "Average Maximum Temperature: ${averageMax}°C"
                    }
                }

            }
            btnDetails.setOnClickListener {
                val intent = Intent(this, DetailedViewsActivity::class.java)
                intent.putExtra("days", days)
                intent.putExtra("minTemp", minTemp)
                intent.putExtra("maxTemp", maxTemp)
                intent.putExtra("condition", condition)
                startActivity(intent)
            }

        }
    }
}