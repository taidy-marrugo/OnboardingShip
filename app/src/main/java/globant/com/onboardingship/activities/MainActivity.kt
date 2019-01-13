package globant.com.onboardingship.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import globant.com.onboardingship.R
import globant.com.onboardingship.adapter.ShipPagerAdapter
import globant.com.onboardingship.mvp.presenter.ShipPresenter
import globant.com.onboardingship.mvp.view.ShipView
import globant.com.onboardingship.utils.bus.RxBus

class MainActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: ShipPagerAdapter
    private  var presenter: ShipPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pagerAdapter = ShipPagerAdapter(supportFragmentManager,applicationContext)// move to shipview
        presenter= ShipPresenter(ShipView(this,pagerAdapter))
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.clear(this)
    }


}
