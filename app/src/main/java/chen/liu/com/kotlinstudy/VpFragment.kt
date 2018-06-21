package chen.liu.com.kotlinstudy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class VpFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val title = arguments!!.getString(TITLE)
        val textView = TextView(context)
        textView.text = title
        textView.gravity = Gravity.CENTER
        return textView
    }

    companion object {
        private const val TITLE = "title"
        fun newInstance(title: String): Fragment{
            val bundle = Bundle()
            bundle.putString(TITLE,title)
            val vpFragment = VpFragment()
            vpFragment.arguments = bundle
            return  vpFragment
        }
    }
}