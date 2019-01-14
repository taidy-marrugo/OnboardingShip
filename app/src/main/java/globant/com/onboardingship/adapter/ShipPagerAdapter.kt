package globant.com.onboardingship.adapter


import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import globant.com.onboardingship.R
import globant.com.onboardingship.fragments.ShipFragment
import globant.com.onboardingship.mvp.model.Ship

class ShipPagerAdapter(fragmentManager: FragmentManager, context: Context) :
        FragmentStatePagerAdapter(fragmentManager) {
    val ships=getShips(context)
    override fun getItem(position: Int): Fragment {
        return ShipFragment.newInstance(ships[position])
    }
    override fun getCount(): Int {
        return ships.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return ships[position % ships.size].title
    }

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