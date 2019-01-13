package globant.com.onboardingship.mvp.view

import android.app.Activity
import android.support.v7.app.AppCompatActivity

import java.lang.ref.WeakReference

open class ActivityView(activity: AppCompatActivity) {
    private val activityRef: WeakReference<AppCompatActivity> = WeakReference(activity)

    open  val activity: AppCompatActivity?
        get() = activityRef.get()


}
