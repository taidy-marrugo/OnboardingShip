package globant.com.onboardingship.mvp.presenter


import android.util.Log
import globant.com.onboardingship.mvp.view.ShipView
import globant.com.onboardingship.utils.bus.RxBus
import globant.com.onboardingship.utils.bus.observer.OnScrollShipBusObserver
import kotlinx.android.synthetic.main.activity_main.*

open class ShipPresenter(view: ShipView) {
    init {
        val activity = view.activity
        var scaleXInit: Float? = activity?.shipImageView?.scaleX
        var scaleYInit: Float? = activity?.shipImageView?.scaleY
        val scalingFactor = 0.05F
        if (activity != null) {
            RxBus.subscribe(activity, object : OnScrollShipBusObserver() {
                override fun onEvent(value: OnScrollMoved) {
                    if (value.position + value.positionOffset >= 0.000 && value.position + value.positionOffset <= 1.0) {//move ship  0 to 1
                        activity.shipImageView.rotation = -90 * (1 - (value.position + value.positionOffset))
                        activity.shipImageView.scaleX = scaleXInit!!
                        activity.shipImageView.scaleY = scaleYInit!!
                    } else if (value.position + value.positionOffset > 1.001 && +value.position + value.positionOffset < 2) {//move ship  1 to 2
                        val before = activity.shipImageView.rotation
                        activity.shipImageView.rotation = value.position + value.positionOffset * 90
                        val after = activity.shipImageView.rotation
                        if (before < after) {
                            activity.shipImageView.scaleX = activity.shipImageView.scaleX + scalingFactor
                            activity.shipImageView.scaleY = activity.shipImageView.scaleY + scalingFactor

                        } else {
                            activity.shipImageView.scaleX = activity.shipImageView.scaleX - scalingFactor
                            activity.shipImageView.scaleY = activity.shipImageView.scaleY - scalingFactor
                        }

                    } else if (value.position + value.positionOffset >= 2) {
                        activity.shipImageView.rotation = 90F
                    }

                }
            })
        }
    }
}