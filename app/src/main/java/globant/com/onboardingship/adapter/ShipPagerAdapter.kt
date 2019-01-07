package globant.com.onboardingship.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import globant.com.onboardingship.fragments.ShipFragment
import globant.com.onboardingship.mvp.model.Ship

class ShipPagerAdapter(fragmentManager: FragmentManager, private val ships: ArrayList<Ship>) :
        FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return ShipFragment.newInstance(ships[position])
    }
    override fun getCount(): Int {
        return ships.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return ships[position % ships.size].title
    }
}