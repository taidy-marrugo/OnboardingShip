package globant.com.onboardingship.mvp.view

import android.app.Activity

import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    open  val activity: Activity?
        get() = activityRef.get()


}
