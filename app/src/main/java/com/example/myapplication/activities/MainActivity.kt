package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.dto.Name
import com.example.myapplication.services.CountriesService
import org.json.JSONObject
import org.json.JSONStringer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var button:Button
    lateinit var buttonCountry:Button
    lateinit var text:TextView
    lateinit var service: CountriesService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button =  findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
        buttonCountry =  findViewById<Button>(R.id.button_country)
        buttonCountry.setOnClickListener(this)

        text = findViewById(R.id.text)
        Log.d("LIFECYCLE","onCreate")
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://restcountries.com/v3.1/")
            .build()

        service = retrofit.create(CountriesService::class.java)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE","onDestroy")
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.button) {
            Log.d("CLICK","Click in my button")
            text.text = "Você apertou o meu botão"
            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("EXTRA", Name("Iago","Iago Laguna"))
            startActivity(intent)
        }

        if(v?.id == R.id.button_country) {
            Log.d("CLICK","Get Country")
            val call = service.getCountries("Brasil")
             Thread {
               kotlin.run {
                   val data = call.request()
                   val body = data.body()
                   Log.d("DATA", body.toString())
               }
             }.start()
        }
    }
}