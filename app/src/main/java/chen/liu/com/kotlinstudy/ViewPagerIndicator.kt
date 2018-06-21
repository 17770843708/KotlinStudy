package chen.liu.com.kotlinstudy

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView

class ViewPagerIndicator : LinearLayout{
    var triangleColor: Int = Color.RED  //指示条颜色 可设置
        set(value) {
            field = if(value<0) 0 else value
        }
    var showItemCount = 4   //显示的item个数 可设置
        set(value) {
            field = if(value<=0) 4 else value
        }
    val itemTextColor: Int = Color.BLACK    //标题字体颜色
    var tabItemTitles: Array<String>? = null    //标题数组
        set(value) {
            field = value
            removeAllViews()
            if (field != null) {
                for (title in field!!){
                    addView(createItem(title))
                }
            }
        }
    var viewPager: ViewPager? = null
        set(value) {
            viewPagerListen(value)
            field = value
        }
    private val paint = Paint() //画笔
    private val path = Path()
    private var itemWith: Int = 0   //没个item的宽度

    constructor(context: Context) : super(context)

    constructor(context: Context,attrs: AttributeSet) : super(context,attrs){
        val typeArray = context.obtainStyledAttributes(attrs,R.styleable.ViewPagerIndicator)
        var mTabVisibleCount = typeArray.getInt(R.styleable.ViewPagerIndicator_visible_tab_count, COUNT_DEFAULT_TAB)
        typeArray.recycle()
        if (mTabVisibleCount<=0){
            mTabVisibleCount = COUNT_DEFAULT_TAB
        }

        itemWith = getScreenWitch()/showItemCount

        //初始化画笔
        paint.isAntiAlias = true
        paint.color = triangleColor
        paint.style = Paint.Style.FILL
    }

    private fun viewPagerListen(viewPager: ViewPager?){
        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageSelected(position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.i("tag", "onPageScrollStateChanged:$state")
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Log.i("tag","onPageScrolled:$position $positionOffset $positionOffsetPixels")
            }
        })
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        initMark()
    }

    //初始化指示条
    private fun initMark(){
        path.moveTo(0f,0f)
        path.lineTo(0f,-8f)
        path.lineTo(itemWith.toFloat(),-8f)
        path.lineTo(itemWith.toFloat(),0f)
        path.close()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        canvas?.save()
        canvas?.translate(0f,height.toFloat())
        canvas?.drawPath(path,paint)
        canvas?.restore()
    }


    //通过title创建当item
    private fun createItem(title: String): View{
        val textView = TextView(context)
        val layoutParams: LinearLayout.LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
        layoutParams.width = itemWith
        textView.layoutParams = layoutParams
        textView.text = title
        textView.gravity = Gravity.CENTER
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
        textView.setTextColor(itemTextColor)
        return textView
    }

    //获取屏幕宽度
    private fun getScreenWitch(): Int{
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    companion object {
        //默认显示4个item
        private const val COUNT_DEFAULT_TAB = 4
    }
}