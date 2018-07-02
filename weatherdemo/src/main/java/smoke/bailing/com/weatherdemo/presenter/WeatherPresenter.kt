package smoke.bailing.com.weatherdemo.presenter

interface WeatherPresenter {
    fun requestDailyWeather(location: String,start: Int,days: Int)
}