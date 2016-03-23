package com.nevantia.weatherapp.domain.commands

import com.nevantia.weatherapp.data.ForecastRequest
import com.nevantia.weatherapp.domain.mappers.ForecastDataMapper
import com.nevantia.weatherapp.domain.model.ForecastList

/**
 * Created by d_garcia on 23/03/2016.
 */

class RequestForecastCommand(val zipCode: String): Command<ForecastList>{
    override fun execute(): ForecastList {

        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
