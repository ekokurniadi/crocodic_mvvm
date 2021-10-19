package id.ekokurniadi.myapplication.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import id.ekokurniadi.myapplication.api.ApiResponse
import id.ekokurniadi.myapplication.api.ApiService
import id.ekokurniadi.myapplication.data.Session
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


open class BaseViewModel: ViewModel(), LifecycleObserver {

    @Inject
    lateinit var session: Session
    @Inject
    lateinit var gson: Gson
    @Inject
    open lateinit var apiService: ApiService

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val apiResponse = MutableLiveData<ApiResponse>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}