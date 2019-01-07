package globant.com.onboardingship.utils

import android.content.Context
import globant.com.onboardingship.R
import globant.com.onboardingship.mvp.model.Ship

object ShipHelper {
    fun getShips(context: Context): ArrayList<Ship> {
        val ships = ArrayList<Ship>()
        val list = context.resources.getStringArray(R.array.items_title)
        for (i in 0 until list.size) {
            val shipTitle = list[i]
            ships.add(Ship(shipTitle))
        }
        return ships
    }
}