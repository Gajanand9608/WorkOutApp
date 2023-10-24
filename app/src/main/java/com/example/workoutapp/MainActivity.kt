package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.flStart.setOnClickListener {
            // to move to new using intent
            var intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }
        binding.flBMI.setOnClickListener {
            var intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }
        binding?.flHistory?.setOnClickListener {
            var intent = Intent(this, HistoryAcitvity::class.java)
            startActivity(intent)
        }


    }


}