package globant.com.onboardingship.mvp.presenter

import globant.com.onboardingship.mvp.view.ShipView
import globant.com.onboardingship.utils.bus.RxBus
import globant.com.onboardingship.utils.bus.observer.OnScrollShipBusObserver

open class  ShipPresenter (view: ShipView){
    init {
        val activity = view.activity
        if (activity!=null){
            RxBus.subscribe(activity, object : OnScrollShipBusObserver(){
                override fun onEvent(value: OnScrollMoved) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
    }
}