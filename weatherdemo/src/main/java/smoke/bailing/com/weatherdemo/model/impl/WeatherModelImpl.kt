package smoke.bailing.com.weatherdemo.model.impl

import com.google.gson.Gson
import smoke.bailing.com.weatherdemo.model.WeatherModel
import smoke.bailing.com.weatherdemo.model.entity.WeatherBean

class WeatherModelImpl: WeatherModel {
    override fun getDailyWeather(key: String, location: String, language: String, unit: String, start: Int, days: Int): WeatherBean {
        val date = "{\"results\":[{\"location\":{\"id\":\"WX4FBXXFKE4F\",\"name\":\"北京\",\"country\":\"CN\",\"path\":\"北京,北京,中国\",\"timezone\":\"Asia/Shanghai\",\"timezone_offset\":\"+08:00\"},\"daily\":[{\"date\":\"2018-06-21\",\"text_day\":\"多云\",\"code_day\":\"4\",\"text_night\":\"多云\",\"code_night\":\"4\",\"high\":\"35\",\"low\":\"23\",\"precip\":\"\",\"wind_direction\":\"东南\",\"wind_direction_degree\":\"135\",\"wind_speed\":\"10\",\"wind_scale\":\"2\"},{\"date\":\"2018-06-22\",\"text_day\":\"雷阵雨\",\"code_day\":\"11\",\"text_night\":\"多云\",\"code_night\":\"4\",\"high\":\"32\",\"low\":\"21\",\"precip\":\"\",\"wind_direction\":\"南\",\"wind_direction_degree\":\"180\",\"wind_speed\":\"10\",\"wind_scale\":\"2\"},{\"date\":\"2018-06-23\",\"text_day\":\"多云\",\"code_day\":\"4\",\"text_night\":\"晴\",\"code_night\":\"1\",\"high\":\"34\",\"low\":\"23\",\"precip\":\"\",\"wind_direction\":\"南\",\"wind_direction_degree\":\"180\",\"wind_speed\":\"10\",\"wind_scale\":\"2\"}],\"last_update\":\"2018-06-21T11:00:00+08:00\"}]}"
        return Gson().fromJson(date,WeatherBean::class.java)
    }
}