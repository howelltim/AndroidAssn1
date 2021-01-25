package com.android.example.app_assignment1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.app_assignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val count: Count = Count()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.count = count
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.toastButton.setOnClickListener{
            Toast.makeText(this, "Hello " + binding.apply{ textView.text }, Toast.LENGTH_SHORT)
        }
        binding.countUpButton.setOnClickListener{
            countUp()
        }
        binding.countDownButton.setOnClickListener{
            countDown()
        }
    }
    private fun countUp(){
        binding.apply{
            var currentValue = Integer.parseInt(textView.text.toString())
            count?.num = currentValue++.toString()
            invalidateAll()
        }
    }
    private fun countDown(){
        binding.apply{
            var currentValue = Integer.parseInt(textView.text.toString())
            count?.num = currentValue--.toString()
            invalidateAll()
        }
    }
}