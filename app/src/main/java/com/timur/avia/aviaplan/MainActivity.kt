package com.timur.avia.aviaplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timur.avia.aviaplan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.name.setText("Avia Planner")
        binding.charts.setText("Price Charts")
        binding.ideas.setText("Travel Ideas")
        binding.instructions.setText("Travel Instructions")
        binding.about.setText("About")
        binding.privacy.setText("Privacy Policy")
        binding.charts.setOnClickListener{
            startActivity(Intent(this, PriceCharts::class.java))
        }
        binding.about.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }
        binding.privacy.setOnClickListener {
            startActivity(Intent(this, PP::class.java))
        }
        binding.ideas.setOnClickListener {
            startActivity(Intent(this, Ideas::class.java))
        }
        binding.instructions.setOnClickListener {
            startActivity(Intent(this, Instructions::class.java))
        }
    }
}