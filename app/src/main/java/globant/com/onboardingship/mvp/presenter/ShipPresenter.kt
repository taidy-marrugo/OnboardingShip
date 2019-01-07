package globant.com.onboardingship.mvp.presenter

import android.opengl.Visibility
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import globant.com.onboardingship.R
import globant.com.onboardingship.fragments.ShipFragment
import globant.com.onboardingship.mvp.view.ShipView
import globant.com.onboardingship.utils.bus.RxBus
import globant.com.onboardingship.utils.bus.observer.OnScrollShipBusObserver
import kotlinx.android.synthetic.main.activity_main.*

open class ShipPresenter(view: ShipView) {
    init {
        val activity = view.activity
        if (activity != null) {
            RxBus.subscribe(activity, object : OnScrollShipBusObserver() {
                override fun onEvent(value: OnScrollMoved) {
                    if (value.position == 0) {
                        activity.shipImageView.rotation = value.number
                        activity.shipImageView.scaleX = 0.6F
                        activity.shipImageView.scaleY = 0.6F
                    } else if (value.position == 1) {
                        activity.shipImageView.rotation = 90F
                        activity.shipImageView.scaleX = 0.6F
                        activity.shipImageView.scaleY = 0.6F
                    } else if (value.position == 2) {
                        activity.shipImageView.rotation = value.number + 180F
                        activity.shipImageView.scaleX = 0.8F
                        activity.shipImageView.scaleY = 0.8F
                    }
                }
            })
        }
    }
}