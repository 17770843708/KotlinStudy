package liu.chen.com.calendar.presenter

interface DailyWeatherPresenter {
    fun getDailyWeather(location: String,start: Int,days: Int)
}