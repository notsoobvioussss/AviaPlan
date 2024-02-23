package com.timur.avia.aviaplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val zag = findViewById<TextView>(R.id.textViewAboutTitle)
        zag.setText("About")
        val tex = findViewById<TextView>(R.id.textViewAboutContent)
        tex.setText("AviaPlanner is an amazing app that helps you plan your flights easily and efficiently. It provides a user-friendly interface to select your departure and destination cities, choose your travel class, and pick your travel date. The app then recommends normal flight prices based on your preferences. AviaPlanner also features a beautiful gallery of countries to inspire your next adventure.")
    }
}