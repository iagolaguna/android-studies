package com.example.myapplication.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.dto.Name

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        Log.d("SecondActivity","onCreate")
        val intentString =  intent.getSerializableExtra("EXTRA") as Name
        Log.d("SecondActivity", String.format("%s %s",intentString.common,intentString.official))
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity","onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity","onDestroy")
    }
}