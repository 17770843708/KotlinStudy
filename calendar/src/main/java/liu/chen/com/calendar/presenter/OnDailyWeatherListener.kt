package liu.chen.com.calendar.presenter

import liu.chen.com.calendar.model.entity.WeatherBean

interface OnDailyWeatherListener {
    fun onSuccess(weatherBean: WeatherBean)

    fun onError()
}