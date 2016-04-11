package com.nevantia.weatherapp.domain.model


/**
 * Created by d_garcia on 23/03/2016.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>){

    operator fun get(position: Int) = dailyForecast[position]

    fun size() = dailyForecast.size
}


data class Forecast(val date: String, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)
