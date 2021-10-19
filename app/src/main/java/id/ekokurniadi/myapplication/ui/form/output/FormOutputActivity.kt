package id.ekokurniadi.myapplication.ui.form.output

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.view.children
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.constant.Constant
import id.ekokurniadi.myapplication.ui.base.BaseActivity
import id.ekokurniadi.myapplication.ui.form.input.FormInputActivity

class FormOutputActivity : BaseActivity<FormOutputViewModel>() {
    private lateinit var inputLocation: TextView
    private lateinit var datePicker: TextView
    private lateinit var timePicker: TextView
    private lateinit var checkAcc1: CheckBox
    private lateinit var checkAcc2: CheckBox
    private lateinit var checkAcc3: CheckBox
    private lateinit var ratingBar: RatingBar
    private lateinit var radioType: RadioGroup
    private lateinit var btnSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_output)
        inputLocation = findViewById(R.id.input_location)
        datePicker = findViewById(R.id.date_picker)
        datePicker = findViewById(R.id.date_picker)
        timePicker = findViewById(R.id.time_picker)
        checkAcc1 = findViewById(R.id.check_acc1)
        checkAcc2 = findViewById(R.id.check_acc2)
        checkAcc3 = findViewById(R.id.check_acc3)
        ratingBar = findViewById(R.id.rating_bar)
        radioType = findViewById(R.id.radio_type)
        btnSave = findViewById(R.id.btn_save)

        val valueLocation = intent.getStringExtra(Constant.INTENT.KEY_LOCATION)
        val valueType = intent.getStringExtra(Constant.INTENT.KEY_TYPE)
        val valueAccessories = intent.getStringExtra(Constant.INTENT.KEY_ACC)
        val valueTime = intent.getStringExtra(Constant.INTENT.KEY_TIME)
        val valueRating = intent.getFloatExtra(Constant.INTENT.KEY_RATING,0F)
        val valueDate = intent.getStringExtra(Constant.INTENT.KEY_DATE)

        inputLocation.text= valueLocation
        datePicker.text = valueDate
        timePicker.text = valueTime



        val listAcc = Gson().fromJson<List<String>>(valueAccessories,object : TypeToken<List<String>>(){}.type)

        listAcc.forEach {
            if(checkAcc1.text==it){
                checkAcc1.isChecked = true
            }

            if(checkAcc2.text==it){
                checkAcc2.isChecked = true
            }
            if(checkAcc3.text==it){
                checkAcc3.isChecked = true
            }


        }


        radioType.children.forEach {
            val radioButton = it as RadioButton
            radioButton.isChecked = radioButton.text == valueType
        }

        ratingBar.rating = valueRating

        btnSave.setOnClickListener {


            val outputIntent = Intent(this,FormInputActivity::class.java).apply {
            }
            startActivity(outputIntent)
        }    }
}
