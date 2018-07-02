package smoke.bailing.com.weatherdemo.presenter.impl

import smoke.bailing.com.weatherdemo.model.impl.WeatherModelImpl
import smoke.bailing.com.weatherdemo.presenter.WeatherPresenter
import smoke.bailing.com.weatherdemo.ui.view.WeatherView

class WeatherPresenterImpl(private val weatherView: WeatherView): WeatherPresenter {
    private val weatherModel = WeatherModelImpl()

    override fun requestDailyWeather(location: String, start: Int, days: Int) {
        val weatherBean = weatherModel.getDailyWeather("lfdhysybwgjm3spp",location,
                "zh-Hans","c",start,days)
        weatherView.setWeatherInfo(weatherBean)
    }

}