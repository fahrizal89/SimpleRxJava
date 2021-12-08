package id.fahrizal.simplerxjava.observer

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * @author Fahrizal Sentosa (fahrizal.sentosa@dana.id)
 * @version MySingleObservableObserver, v 0.1 08/12/21 07.19 by Fahrizal Sentosa
 */
abstract class MySingleObservableObserver<T> : SingleObserver<T> {

    private var disposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onSuccess(t: T) {
        onSucceed(t)
        disposable?.dispose()
    }

    override fun onError(e: Throwable) {
        Timber.e(e)
    }

    abstract fun onSucceed(t: T)
}