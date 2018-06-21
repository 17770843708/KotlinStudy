package chen.liu.com.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titles = arrayOf("标题1","标题2","标题3","标题4","标题5","标题6","标题7","标题8","标题9")
        val fragments = arrayListOf<Fragment>()
        for (title in titles){
            fragments.add(VpFragment.newInstance(title))
        }
        main_vp.adapter = object : FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }

        main_vpi.showItemCount = 5
        main_vpi.tabItemTitles = titles
        main_vpi.viewPager = main_vp


    }



}
