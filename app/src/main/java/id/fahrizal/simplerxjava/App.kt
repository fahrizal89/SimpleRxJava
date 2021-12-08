package id.fahrizal.simplerxjava

import android.app.Application
import timber.log.Timber

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version App, v 0.1 08/12/21 07.26 by Fahrizal Sentosa
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}