package globant.com.onboardingship.mvp.presenter


import android.util.Log
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
                    Log.d("tag1","positionOffset "+value.positionOffset);
                    if (value.position+  value.positionOffset >= 0.000 &&  value.position+value.positionOffset <= 1.0) {//move ship  0 to 1

                        activity.shipImageView.rotation = -90*(1- (value.position+value.positionOffset) )
                        /*if(value.position==2){
                            activity.shipImageView.scaleX=activity.shipImageView.scaleX+(value.positionOffset/10)
                            activity.shipImageView.scaleY=activity.shipImageView.scaleY+(value.positionOffset/10)
                        }else if(value.position==1){
                            activity.shipImageView.scaleX=activity.shipImageView.scaleX-(value.positionOffset/10)
                            activity.shipImageView.scaleY=activity.shipImageView.scaleY-(value.positionOffset/10)
                        }*/
                    } else if (value.position+value.positionOffset > 1.001 &&  +value.position+ value.positionOffset < 2) {//move ship  1 to 2
                        activity.shipImageView.rotation =  value.position+value.positionOffset * 90


                    } else if(value.position+value.positionOffset>=2 ){
                        activity.shipImageView.rotation = 90F
                    }

                }
            })
        }
    }
}