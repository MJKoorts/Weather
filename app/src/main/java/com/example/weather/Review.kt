package com.example.weather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {
    lateinit var txtResult : TextView
    lateinit var btnBack : Button
    lateinit var btnExit2 : Button
    var Days = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        txtResult = findViewById(R.id.txtResult)
        btnBack = findViewById(R.id.btnBack)
        btnExit2 = findViewById(R.id.btnExit2)

        intent.getIntArrayExtra("ArrMin")
        intent.getIntArrayExtra("ArrMax")
        intent.getStringArrayExtra("ArrCon")

        var X = 0

        for (X in 0..6){
            var Result = StringBuilder()

            Result.append(Days[X] + ": " + arrMin[X].toString() + " " + arrMax[X].toString() + " " + arrCon + "\n")
        }

        btnBack.setOnClickListener {
            var Back = Intent(this, Weather_data::class.java)
            startActivity(Back)
            finish()
        }

        btnExit2.setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}