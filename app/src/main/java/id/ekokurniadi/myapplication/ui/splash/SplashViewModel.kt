package id.ekokurniadi.myapplication.ui.splash

import android.os.CountDownTimer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import id.ekokurniadi.myapplication.api.ApiResponse
import id.ekokurniadi.myapplication.data.constant.Constants
import id.ekokurniadi.myapplication.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel() {
    val splashNotifier = MutableLiveData<Boolean>()

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

    fun checkToken() {
        if (session.accessToken.isNullOrEmpty()) {
            getToken()
        } else {
            delayCountDown(3000)
        }
    }

    private fun getToken() {
        compositeDisposable.add(
            apiService.oauthToken()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val responseJson = JSONObject(it)
                    val apiStatus = responseJson.getInt(Constants.REMOTE.API_STATUS)
                    val apiMessage = responseJson.getJSONArray(Constants.REMOTE.API_MESSAGE)

                    if (apiStatus == Constants.REMOTE.API_STATUS_SUCCESS) {
                        val jsonObjectData = responseJson.getJSONObject(Constants.REMOTE.OBJ_DATA)
                        session.saveAccessToken(jsonObjectData.getString("token"))
                        delayCountDown(3000)
                    } else {
                        apiResponse.value = ApiResponse().responseWrong(apiMessage)
                    }
                }, {
                    apiResponse.value = ApiResponse().responseError(it)
                })
        )
    }
}