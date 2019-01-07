package globant.com.onboardingship.utils.bus.observer

import java.text.FieldPosition


abstract class OnScrollShipBusObserver : BusObserver<OnScrollShipBusObserver.OnScrollMoved>
(OnScrollMoved::class.java) {

    class OnScrollMoved (var number:Float, var position:Int)
}