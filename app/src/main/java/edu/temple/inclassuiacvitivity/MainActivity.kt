package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        // multiples of 5 from 5 - 100
        val numberArray = Array(100/5) {
            i -> (i + 1) * 5
        };

        // Create adapter to display items from array in Spinner
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, numberArray)


        // Change TextView's text size to the number selected in the Spinner
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // !! tells compiler that even tho parent is nullable, it probably won't be
                displayTextView.textSize = parent!!.getItemAtPosition(position) as Float
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }
}