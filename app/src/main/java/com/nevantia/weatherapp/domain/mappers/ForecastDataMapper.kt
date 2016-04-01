package com.nevantia.weatherapp.domain.mappers

import com.nevantia.weatherapp.data.Forecast
import com.nevantia.weatherapp.data.ForecastResult
import com.nevantia.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*

// As we are using two classes with the same name, we can give a specific name to one of them so that
// we don’t need to write the complete package:
import com.nevantia.weatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by d_garcia on 23/03/2016.
 */

public class ForecastDataMapper {

    // Combierte de los datos recibidos a mi dominio
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())

        return df.format(date * 1000)
    }


}