package smoke.bailing.com.weatherdemo.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import smoke.bailing.com.weatherdemo.R
import smoke.bailing.com.weatherdemo.model.entity.WeatherBean
import smoke.bailing.com.weatherdemo.presenter.impl.WeatherPresenterImpl
import smoke.bailing.com.weatherdemo.ui.view.WeatherView

class MainActivity : AppCompatActivity(),WeatherView, View.OnClickListener {
    private val weatherPresenter = WeatherPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainSelect.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.mainSelect -> {
                weatherPresenter.requestDailyWeather("beijing",0,5)
            }
        }
    }

    override fun setWeatherInfo(weatherBean: WeatherBean) {
        date.text = weatherBean.results[0].daily[0].date
        text_day.text = weatherBean.results[0].daily[0].text_day
        code_day.text = weatherBean.results[0].daily[0].code_day
        text_night.text = weatherBean.results[0].daily[0].text_night
        code_night.text = weatherBean.results[0].daily[0].code_night
        high.text = weatherBean.results[0].daily[0].high
        low.text = weatherBean.results[0].daily[0].low
        precip.text = weatherBean.results[0].daily[0].precip
        wind_direction.text = weatherBean.results[0].daily[0].wind_direction
        wind_direction_degree.text = weatherBean.results[0].daily[0].wind_direction_degree
        wind_speed.text = weatherBean.results[0].daily[0].wind_speed
        wind_scale.text = weatherBean.results[0].daily[0].wind_scale
    }
}
