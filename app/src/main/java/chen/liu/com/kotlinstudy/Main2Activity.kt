package chen.liu.com.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /**
         * let函数适用的场景
         * 场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理
         * 场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用
         */
        //场景一
        val user: User? = User("老大",18,"123456")
        user?.let {
            Log.i("tag","user不为空")
        }
        //场景二
        user?.let {
            Log.i("tag",it.name)
            Log.i("tag",it.age.toString())
            Log.i("tag",it.phoneNumber)
        }
        /**
         * with函数的适用的场景
         * 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView
         * 中onBinderViewHolder中，数据model的属性映射到UI上
         */
        val user1 = User("老二",17,"123456")
        val result = with(user1, {
            Log.i("tag","my name is $name, I am $age years old, my phone number is $phoneNumber")
            "哈哈哈"
        })
        Log.i("tag",result)

        /**
         * run函数的适用场景
         * 适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it
         * 参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with
         * 函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
         */
        val user2: User? = User("老三",16,"123456")
        /*val result1 = with(user2, {
            Log.i("tag","my name is $name, I am $age years old, my phone number is $phoneNumber")
            "哈哈哈"
        })
        Log.i("tag",result)*/
        val result1 = user2?.run {
            Log.i("tag","my name is $name, I am $age years old, my phone number is $phoneNumber")
            "哈哈哈1"
        }
        Log.i("tag",result1)

        /**
         * apply函数的适用场景
         * 整体作用功能和run函数很像，唯一不同点就是它返回的值是对象本身，而run函数是一个闭包形式返回，返回的是最
         * 后一行的值。正是基于这一点差异它的适用场景稍微与run函数有点不一样。apply一般用于一个对象实例初始化的时
         *候，需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，这种情
         * 景非常常见。特别是在我们开发中会有一些数据model向View model转化实例化的过程中需要用到
         */
        val user3 = User("老四",15,"123456")
        val result2 = user3.apply {
            name = "老五"
            age = 14
            phoneNumber = "123456"
        }
        Log.i("tag","my name is ${result2.name}, I am ${result2.age} years old, my phone number is ${result2.phoneNumber}")

        /**
         * also函数的适用场景
         * 适用于let函数的任何场景，also函数和let很像，只是唯一的不同点就是let函数最后的返回值是最后一行的返回
         * 值而also函数的返回值是返回当前的这个对象。一般可用于多个扩展函数链式调用
         */
        Log.i("tag","老大")
        val user4 = User("老五",14,"123456")
    }

    class User(var name: String,var age: Int,var phoneNumber: String)
}
