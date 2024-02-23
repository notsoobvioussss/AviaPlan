package com.timur.avia.aviaplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.timur.avia.aviaplan.databinding.ActivityInstructionsBinding

class Instructions : AppCompatActivity() {
    lateinit var binding: ActivityInstructionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.checkin.setOnClickListener {
            startActivity(Intent(this, CheckIn::class.java))
        }
        binding.transport.setOnClickListener {
            startActivity(Intent(this, Transport::class.java))
        }
        binding.boarding.setOnClickListener {
            startActivity(Intent(this, Boarding::class.java))
        }
        binding.planeeee.setOnClickListener{
            Toast.makeText(this, "Enjoy your flight", Toast.LENGTH_SHORT).show()
        }
    }
}