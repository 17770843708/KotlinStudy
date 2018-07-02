package smoke.bailing.com.weatherdemo.model

import smoke.bailing.com.weatherdemo.model.entity.WeatherBean

interface WeatherModel {
    fun getDailyWeather(key: String,location: String,language: String,unit: String,start: Int,days: Int): WeatherBean
}