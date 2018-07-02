package liu.chen.com.calendar.ui.view

import liu.chen.com.calendar.model.entity.WeatherBean

interface DailyWeatherView {
    fun showDailyWeatherLoading()

    fun setDailyWeatherInfo(weatherBean: WeatherBean)

    fun showDailyWeatherError()
}