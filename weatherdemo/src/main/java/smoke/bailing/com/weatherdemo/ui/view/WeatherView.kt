package smoke.bailing.com.weatherdemo.ui.view

import smoke.bailing.com.weatherdemo.model.entity.WeatherBean

interface WeatherView {
    fun setWeatherInfo(weatherBean: WeatherBean)
}