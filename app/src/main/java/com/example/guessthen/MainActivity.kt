package com.example.guessthen

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Variable to store random number
        val randomNumber = (1..100).random()

        Log.v("Random Number", "Generated number:$randomNumber")

        //Link UI elements to kotlin

        val displayButton = findViewById<Button>(R.id.Displaybutton)
        val inputNumber = findViewById<EditText>(R.id.editTextNumber)
        val displayMessage = findViewById<TextView>(R.id.TextView)
// variable outside the click button otherwise every time the user click the button the guess counter would reset to zero
        var guessQuantity = 0

        //Add code when display button is clicked
        displayButton?.setOnClickListener {
            var guess = inputNumber.text.toString().toInt()



            Toast. makeText(this,
                "Guessing number!", Toast.LENGTH_LONG).show()
            //Every time the use make a guess don't matter if is right or not
            guessQuantity ++


            //Added if statement to check the guess against the random number
            if (guess == randomNumber) {
                displayMessage.text = "Corect!!"
            } else {
              if (guessQuantity >=5 && guess!= randomNumber) {
                  displayMessage.text= "Opss!! You lost !"
              } else {
                if (guess > randomNumber) {
                  displayMessage.text = "Too high"
                }else{
                    displayMessage.text = "Too Low!"
                }

              }
            }





        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}