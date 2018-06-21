package chen.liu.com.kotlinstudy

import android.util.Log

class GenericityTest<Z : Any>(private val generosity: Z){

    constructor(generosity: Z, int: Int) : this(generosity){
        Log.i("tag","int:"+int)
    }

    fun checkT(){
        when{
            generosity is String -> Log.i("tag", "string")
            generosity is Int -> Log.i("tag","int")
            generosity is Double -> Log.i("tag","double")
        }
    }
}