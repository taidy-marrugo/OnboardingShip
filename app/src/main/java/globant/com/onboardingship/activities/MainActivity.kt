package globant.com.onboardingship.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import globant.com.onboardingship.R
import globant.com.onboardingship.utils.ShipHelper
import globant.com.onboardingship.adapter.ShipPagerAdapter
import globant.com.onboardingship.mvp.presenter.ShipPresenter
import globant.com.onboardingship.mvp.view.ShipView

class MainActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: ShipPagerAdapter
    private  var presenter: ShipPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ships = ShipHelper.getShips(this)
        pagerAdapter = ShipPagerAdapter(supportFragmentManager, ships)
        presenter= ShipPresenter(ShipView(this,pagerAdapter))
    }
}
