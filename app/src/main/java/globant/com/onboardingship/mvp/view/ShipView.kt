package globant.com.onboardingship.mvp.view

import android.app.Activity
import android.support.v4.view.ViewPager
import com.squareup.picasso.Picasso
import globant.com.onboardingship.adapter.ShipPagerAdapter
import globant.com.onboardingship.utils.bus.RxBus
import globant.com.onboardingship.utils.bus.observer.OnScrollShipBusObserver

import kotlinx.android.synthetic.main.activity_main.*

open class ShipView(activity: Activity, pagerAdapter: ShipPagerAdapter) : ActivityView(activity) {
    init {//string to constants, init long
        Picasso.with(activity)
                .load(activity.resources.getIdentifier("ship", "drawable", activity.packageName))
                .into(activity.shipImageView)


        activity.viewPager.adapter = pagerAdapter
        activity.viewPager.setCurrentItem(1, true)
        activity.recyclerTabLayout.setupWithViewPager(activity.viewPager)

        activity.viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                RxBus.post(OnScrollShipBusObserver.OnScrollMoved(position, positionOffset))
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }

}