package com.example.weather

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.widget.TextView

var arrMin = arrayOf(0,0,0,0,0,0,0)
var arrMax = arrayOf(0,0,0,0,0,0,0)
var arrCon = arrayOf("","","","","","","")
var dummy = 0
var strDummy = ""
var sum = 0

class Weather_data : AppCompatActivity() {
    lateinit var btnSubmit : Button
    lateinit var btnReview : Button
    lateinit var btnClear : Button
    lateinit var txtOutput : TextView
    lateinit var btnExit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather_data)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnReview = findViewById(R.id.btnReview)
        btnClear = findViewById(R.id.btnClear)
        txtOutput = findViewById(R.id.txtOutput)
        btnExit = findViewById(R.id.btnExit)
        txtOutput.text = ""

        btnSubmit.setOnClickListener {
         var X = 0

           for (X in 0..6) {
            ShowMinDialog()
               arrMin[X] = dummy
        }


            for (X in 0..6) {
                ShowMaxDialog()
                arrMax[X] = dummy
            }

            for (X in 0..6) {
                ShowConDialog()
                arrCon[X] = strDummy
            }

            for (X in 0..6) {
                if (arrMax[X] < arrMin[X]){
                    Toast.makeText(this, "Please reenter the values for the data that was incorrect", Toast.LENGTH_LONG).show()

                    ShowMinDialog()
                    arrMin[X] = dummy

                    ShowMaxDialog()
                    arrMax[X] = dummy
                }

            }
            for (X in 0..6 ) {
                sum = arrMax[X] + arrMin[X]
            }
            var avg = sum / 14

            txtOutput.text = avg.toString()


        }

        btnReview.setOnClickListener {
          var inent = Intent(this, Review::class.java)
            inent.putExtra("ArrMin",arrMin)
            inent.putExtra("ArrMax",arrMax)
            inent.putExtra("ArrCon",arrCon)

            startActivity(inent)
            finish()
        }

        btnClear.setOnClickListener {
            for (X in 0..6){
                arrMax[X] = 0
                arrMin[X] = 0
                arrCon[X] = ""
                txtOutput.text = ""

            }
        }

        btnExit.setOnClickListener {
            finish()
        }

        }
    private fun ShowMinDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enter the minimum temperature for the weekdays") // Title of your box
        builder.setMessage("Please enter the minimum temperature below") // The message prompt

        // Create the EditText to capture the input
        val inputEditText = EditText(this)
        builder.setView(inputEditText)

        // Set up the "OK" button
        builder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
            val userInput = inputEditText.text.toString()

            dummy = userInput.toInt()

        }

        // Set up the "Cancel" button
        builder.setNegativeButton("Cancel") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
        }

        builder.show()

    }

    private fun ShowMaxDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enter the Maximum temperature for the weekdays") // Title of your box
        builder.setMessage("Please enter the Maximum temperature below") // The message prompt

        // Create the EditText to capture the input
        val inputEditText = EditText(this)
        builder.setView(inputEditText)

        // Set up the "OK" button
        builder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
            val userInput = inputEditText.text.toString()

            dummy = userInput.toInt()

        }

        // Set up the "Cancel" button
        builder.setNegativeButton("Cancel") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
        }

        builder.show()

    }

    private fun ShowConDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enter the Weather condition for the weekdays") // Title of your box
        builder.setMessage("Please enter the Weather condition below") // The message prompt

        // Create the EditText to capture the input
        val inputEditText = EditText(this)
        builder.setView(inputEditText)

        // Set up the "OK" button
        builder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
            val userInput = inputEditText.text.toString()

            strDummy = userInput.toString()

        }

        // Set up the "Cancel" button
        builder.setNegativeButton("Cancel") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
        }

        builder.show()

    }
}
