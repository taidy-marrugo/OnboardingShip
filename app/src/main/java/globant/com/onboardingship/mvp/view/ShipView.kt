package globant.com.onboardingship.mvp.view

import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.squareup.picasso.Picasso
import globant.com.onboardingship.adapter.ShipPagerAdapter
import globant.com.onboardingship.utils.Constants
import globant.com.onboardingship.utils.bus.RxBus
import globant.com.onboardingship.utils.bus.observer.OnScrollShipBusObserver

import kotlinx.android.synthetic.main.activity_main.*

open class ShipView(activity: AppCompatActivity) : ActivityView(activity) {
    val pagerAdapter = ShipPagerAdapter(activity.supportFragmentManager, activity.applicationContext)

    init {
    }


    fun setImageShip() {
        activity?.resources?.getIdentifier(Constants.IMAGE_NAME, Constants.FOLDER, activity?.packageName)?.let {
            Picasso.with(activity)
                    .load(it)
                    .into(activity?.shipImageView)
        }

    }

    fun getImageShip(): ImageView? {
        return activity!!.shipImageView
    }
    fun setAdapter() {
        activity?.viewPager?.adapter = pagerAdapter
        activity?.viewPager?.setCurrentItem(1, true)
        activity?.recyclerTabLayout?.setupWithViewPager(activity?.viewPager)
    }

    fun getPagerScroll() {
        activity?.viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

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