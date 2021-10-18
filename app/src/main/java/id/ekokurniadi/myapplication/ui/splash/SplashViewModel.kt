package id.ekokurniadi.myapplication.ui.splash

import android.os.CountDownTimer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import id.ekokurniadi.myapplication.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashViewModel @Inject constructor(): BaseViewModel(){
    val splashNotifier = MutableLiveData<Boolean>()
//    val userExist = MutableLiveData<User?>()

    private var isFinish = false
    private var isStarted = false
    private var isPause = false
    private var countDownTimer: CountDownTimer? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        isPause = false
        splashNotifier.postValue(isFinish)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        isPause = true
    }


//    /**
//     * mengecek data user pada database tersedia atau tidak
//     */
//    fun checkUserIsExist() {
//        compositeDisposable.add(
//            userRepository.getUserLogin()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    userExist.postValue(it)
//                }, {
//                    userExist.postValue(null)
//                })
//
//        )
//    }


    /**
     * Delay dengan hitungan mundur untuk menampilkan page splash screen
     * @param timeInMillis waktu delay dalam millis
     */
    fun delayCountDown(timeInMillis: Long) {
        isStarted = true
        countDownTimer = object : CountDownTimer(timeInMillis, 1000) {

            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                isFinish = true
                if (!isPause) {
                    splashNotifier.postValue(true)
                }
            }
        }.start()
    }

}