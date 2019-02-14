package roman.kai.nasagallery.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Roman K. on 12/02/2019
 */
class GalleryPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> GalleryFragment.spiritIntance()
            else -> GalleryFragment.curiosityInstance()
        }
    }

    override fun getCount() = 2
}