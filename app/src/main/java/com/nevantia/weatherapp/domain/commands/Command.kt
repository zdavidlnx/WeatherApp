package com.nevantia.weatherapp.domain.commands

/**
 * Created by d_garcia on 23/03/2016.
 */

public interface Command<T> {
    fun execute(): T
}
