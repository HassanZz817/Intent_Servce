package com.example.intentservce

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.util.Log

class MyService : Service() {


    val TAG = "MyService"

    init {
        Log.d(TAG,"Service is running...")
    }
    companion object{
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService(){
            Log.d("hello","Service is stopping")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
      val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, dataString)
        }
        return START_STICKY
    }



}