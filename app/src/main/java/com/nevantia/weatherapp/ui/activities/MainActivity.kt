package com.nevantia.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.nevantia.weatherapp.ForecastListAdapter
import com.nevantia.weatherapp.R
import com.nevantia.weatherapp.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        forecastList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = RequestForecastCommand("94043").execute()

            uiThread {

                Log.i("Datos-Recibidos", result.toString())
                forecastList.adapter = ForecastListAdapter(result) { toast(it.date) }
            }
        }

    }
}
