package liu.chen.com.calendar.presenter.impl

import liu.chen.com.calendar.model.entity.WeatherBean
import liu.chen.com.calendar.model.impl.DailyWeatherModelImpl
import liu.chen.com.calendar.presenter.DailyWeatherPresenter
import liu.chen.com.calendar.presenter.OnDailyWeatherListener
import liu.chen.com.calendar.ui.view.DailyWeatherView

class DailyWeatherPresenterImpl(private val dailyWeatherView: DailyWeatherView): DailyWeatherPresenter, OnDailyWeatherListener {
    private val dailyWeatherModel = DailyWeatherModelImpl()

    override fun getDailyWeather(location: String, start: Int, days: Int) {
        dailyWeatherView.showDailyWeatherLoading()
        dailyWeatherModel.loadDailyWeather("lfdhysybwgjm3spp",location,
                "zh-Hans","c",start,days,this)
    }

    override fun onSuccess(weatherBean: WeatherBean) {
        dailyWeatherView.setDailyWeatherInfo(weatherBean)
    }

    override fun onError() {
        dailyWeatherView.showDailyWeatherError()
    }
}