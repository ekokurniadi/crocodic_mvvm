package id.ekokurniadi.myapplication.ui.form.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.ui.base.BaseActivity
import id.ekokurniadi.myapplication.ui.form.input.FormInputActivity

class VisitListActivity : BaseActivity<VisitListViewModel>() {

    private lateinit var listVisit:RecyclerView
    private lateinit var btnAdd:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit_list)

        btnAdd = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener {
            val inputIntent = Intent(this,FormInputActivity::class.java)
            startActivityForResult(
                inputIntent,100
            )
        }

        listVisit = findViewById(R.id.list_visit)
        listVisit.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)


        getData()


    }
    private fun getData(){
        viewModel.getData{
            val adapterVisit = VisitListAdapter(this,it)
            listVisit.adapter = adapterVisit
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        getData()
    }
}
