package id.ekokurniadi.myapplication.ui.form.list

import android.util.Log
import androidx.lifecycle.viewModelScope
import id.ekokurniadi.myapplication.data.room.visit.Visit
import id.ekokurniadi.myapplication.data.room.visit.VisitDao
import id.ekokurniadi.myapplication.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class VisitListViewModel @Inject constructor(val visitDao: VisitDao) : BaseViewModel(){
    fun getData(done: (visit: List<Visit>) -> Unit) = viewModelScope.launch {
        val datas = visitDao.getAll()
        done(datas)
    }
}