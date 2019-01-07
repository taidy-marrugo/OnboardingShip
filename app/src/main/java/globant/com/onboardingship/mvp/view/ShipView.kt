package globant.com.onboardingship.mvp.view

import android.app.Activity
import android.support.v4.view.ViewPager

import globant.com.onboardingship.adapter.ShipPagerAdapter

import kotlinx.android.synthetic.main.activity_main.*

open class  ShipView (activity: Activity, pagerAdapter: ShipPagerAdapter) : ActivityView(activity) {
    init {
        activity.viewPager.adapter=pagerAdapter
        activity.viewPager.setCurrentItem(1,false)
        activity.recyclerTabLayout.setUpWithViewPager(activity.viewPager)

        activity. viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {

            }

        })
    }
}