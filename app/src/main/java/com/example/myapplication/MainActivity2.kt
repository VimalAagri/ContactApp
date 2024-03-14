package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Retrieving data passed from MainActivity
        val imageResourceId = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")

        // Setting up views
        val imageView = findViewById<ImageView>(R.id.imageView2)
        val nameTextView = findViewById<TextView>(R.id.textView3)

        // Binding data to views
        imageView.setImageResource(imageResourceId)
        nameTextView.text = name

    }
}