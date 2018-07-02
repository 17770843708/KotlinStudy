package liu.chen.com.calendar.model

import liu.chen.com.calendar.presenter.OnDailyWeatherListener

interface DailyWeatherModel {
    fun loadDailyWeather(key: String,location: String,
                         language: String,unit: String,start: Int,days: Int,
                         onDailyWeatherListener: OnDailyWeatherListener)
}