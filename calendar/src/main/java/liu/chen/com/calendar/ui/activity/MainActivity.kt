package liu.chen.com.calendar.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.PopupWindow
import com.blankj.utilcode.util.TimeUtils
import kotlinx.android.synthetic.main.activity_main.*
import liu.chen.com.calendar.R
import liu.chen.com.calendar.model.entity.WeatherBean
import liu.chen.com.calendar.presenter.impl.DailyWeatherPresenterImpl
import liu.chen.com.calendar.ui.view.DailyWeatherView
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity(), View.OnClickListener, DailyWeatherView {
    private val dailyWeatherPresenter = DailyWeatherPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView(){
        mainCalendar
                .setStartEndDate("1900.1", "2049.12")
                .setInitDate(TimeUtils.getNowString(SimpleDateFormat("yyyy.MM")))
                //.setSingleDate(TimeUtils.getNowString(SimpleDateFormat("yyyy.MM.dd")))
                .init()
        val list = arrayListOf("2018.06.26","2018.06.27")
        mainCalendar.setMultiDate(list)

        mainMore.setOnClickListener(this)
        mainWeather.setOnClickListener(this)
    }

    override fun showDailyWeatherLoading() {
        Log.i("tag","开始获取天气")
    }

    override fun setDailyWeatherInfo(weatherBean: WeatherBean) {
        Log.i("tag","已获取天气:"+weatherBean.results[0].daily[0].text_night)
    }

    override fun showDailyWeatherError() {
        Log.i("tag","获取天气异常")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mainMore ->{
                val popupWindowView = layoutInflater.inflate(R.layout.popup_window_list,null)
                val popupWindow = PopupWindow(popupWindowView,400,550)
                popupWindow.isFocusable = true
                popupWindow.isOutsideTouchable = true
                popupWindow.update()
                popupWindow.showAsDropDown(mainMore,-235,0)
                //popupWindow.showAtLocation(mainMore,Gravity.CENTER,120,0)
            }
            R.id.mainWeather ->{
                dailyWeatherPresenter.getDailyWeather("beijing",0,5)
            }
        }
    }
}
