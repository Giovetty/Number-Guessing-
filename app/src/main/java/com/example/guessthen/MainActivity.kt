package com.example.guessthen

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Variable to store random number
        val randomNumber = (1..100).random()

        Log.v("Random Number", "Generated number:$randomNumber")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Link UI elements to kotlin
        val displayButton = findViewById<Button>(R.id.Displaybutton)
        val inputNumber = findViewById<EditText>(R.id.editTextNumber)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}