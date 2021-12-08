package id.fahrizal.simplerxjava.ext

import id.fahrizal.simplerxjava.observer.MySingleObservableObserver
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version ObservableExt, v 0.1 08/12/21 07.18 by Fahrizal Sentosa
 */
object ObservableExt {

    fun <T> Single<T>.execute(observer: MySingleObservableObserver<T>? = null): Single<T> {
        val single = subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        if (observer != null) {
            single.subscribe(observer)
        } else {
            single.subscribe()
        }
        return this
    }
}