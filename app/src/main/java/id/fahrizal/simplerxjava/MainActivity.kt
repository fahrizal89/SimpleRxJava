package id.fahrizal.simplerxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.fahrizal.simplerxjava.ext.ObservableExt.execute
import id.fahrizal.simplerxjava.observer.MySingleObservableObserver
import io.reactivex.Single
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executeFetchName()
    }

    private fun executeFetchName() {
        Single.just(fetchName())
            .execute(object : MySingleObservableObserver<String>() {
                override fun onSucceed(t: String) {
                    Timber.d(t)
                }
            })
    }

    private fun fetchName(): String = "get name"
}