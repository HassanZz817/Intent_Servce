package com.example.intentservce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.intentservce.MyIntentService.Companion.stopService
import com.example.intentservce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnStartService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                binding.tvServiceInfo.text = "Service Running"
            }
        }

        binding.btnStopService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                binding.tvServiceInfo.text = "Service Stopped"
            }
        }
        binding.sendData.setOnClickListener{
            Intent(this, MyService::class.java).also {
                val dataString = binding.etString.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }
    }
}