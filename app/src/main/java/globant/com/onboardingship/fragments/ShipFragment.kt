package globant.com.onboardingship.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import globant.com.onboardingship.R

import globant.com.onboardingship.mvp.model.Ship

class ShipFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ship, container, false)
        return view
    }

    companion object {
        fun newInstance(ship: Ship): ShipFragment {
            val args = Bundle()
            val fragment = ShipFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
