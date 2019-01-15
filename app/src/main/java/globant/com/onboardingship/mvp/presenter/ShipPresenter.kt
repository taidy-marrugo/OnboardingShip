package globant.com.onboardingship.mvp.presenter


import android.util.Log
import globant.com.onboardingship.mvp.view.ShipView
import globant.com.onboardingship.utils.bus.RxBus
import globant.com.onboardingship.utils.bus.observer.OnScrollShipBusObserver
import kotlinx.android.synthetic.main.activity_main.*

open class ShipPresenter(view: ShipView) {
    init {
        val activity = view.activity
        view.setImageShip()
        view.setAdapter()
        view.getPagerScroll()

        var scaleXInit: Float? = view.getImageShip()?.scaleX
        var scaleYInit: Float? = view.getImageShip()?.scaleY
        val scalingFactor = 0.5F

        if (activity != null) {
            RxBus.subscribe(activity, object : OnScrollShipBusObserver() {
                override fun onEvent(value: OnScrollMoved) {
                    if (value.position + value.positionOffset >= 0.000 && value.position + value.positionOffset <= 1.0) {//move ship  0 to 1
                        view.getImageShip()?.rotation = -90 * (1 - (value.position + value.positionOffset))
                        view.getImageShip()?.scaleX = scaleXInit!!
                        view.getImageShip()?.scaleY = scaleYInit!!
                    } else if (value.position + value.positionOffset > 1.001 && +value.position + value.positionOffset < 2) {//move ship  1 to 2
                        view.getImageShip()?.rotation = value.position + value.positionOffset * 90
                        val rotationDelta = (view.getImageShip()?.rotation!! * scalingFactor) / 90F
                        view.getImageShip()?.scaleX = scaleXInit!! + rotationDelta!!
                        view.getImageShip()?.scaleY = scaleYInit!! + rotationDelta!!

                    } else if (value.position + value.positionOffset >= 2) {
                        view.getImageShip()?.rotation = 90F
                        view.getImageShip()?.scaleX = scaleXInit!! + scalingFactor
                        view.getImageShip()?.scaleY = scaleYInit!! + scalingFactor
                    }
                }
            })
        }
    }
}