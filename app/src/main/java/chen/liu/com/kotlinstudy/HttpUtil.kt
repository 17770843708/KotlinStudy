package chen.liu.com.kotlinstudy

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HttpUtil{
    fun doGet(httpUrl: String){
        Thread(Runnable {
            val url = URL(httpUrl)
            val connection  = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 15000
            connection.readTimeout = 60000
            connection.connect()
            if (connection.responseCode == 200){
                val inputStream = connection.inputStream
                val rbs = BufferedReader(InputStreamReader(inputStream,"UTF-8"))
                val stringBuffer = StringBuffer()
                var temp:String? = rbs.readLine()
                while (temp != null){
                    stringBuffer.append(temp)
                    stringBuffer.append("\r\n")
                    temp = rbs.readLine()
                }
                val result = stringBuffer.toString()
                Log.i("tag",result)
            }
        }).start()
    }
}