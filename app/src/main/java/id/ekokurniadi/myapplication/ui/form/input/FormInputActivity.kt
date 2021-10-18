package id.ekokurniadi.myapplication.ui.form.input

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import id.ekokurniadi.myapplication.R
import id.ekokurniadi.myapplication.ui.base.BaseActivity
import java.util.*

class FormInputActivity : BaseActivity<FormInputViewModel>() {

    private  lateinit var inputLocation :AutoCompleteTextView

    private  lateinit var datePicker :TextView
    private  lateinit var timePicker :TextView

    private lateinit var checkAcc1: CheckBox
    private lateinit var checkAcc2: CheckBox
    private lateinit var checkAcc3: CheckBox

    private lateinit var ratingBar: RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_input)

        inputLocation = findViewById(R.id.input_location)
        datePicker= findViewById(R.id.date_picker)
        datePicker = findViewById(R.id.date_picker)
        timePicker = findViewById(R.id.time_picker)

        checkAcc1 = findViewById(R.id.check_acc1)
        checkAcc2 = findViewById(R.id.check_acc2)
        checkAcc3 = findViewById(R.id.check_acc3)

        ratingBar = findViewById(R.id.rating_bar)

        val dataLocation = resources.getStringArray(R.array.location)

        val adapter =ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,dataLocation)

        inputLocation.setAdapter(adapter)

        datePicker.setOnClickListener {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Pilih tanggal")
                .build()

            picker.show(supportFragmentManager, "date")

            picker.addOnPositiveButtonClickListener {
                Log.d("tanggal", "${picker.selection}")

                val calendar = Calendar.getInstance()
                calendar.timeInMillis = picker.selection!!

                datePicker.text = "${calendar[Calendar.YEAR]} - ${calendar[Calendar.MONTH]+1} - ${calendar[Calendar.DATE]}"
            }

            timePicker.setOnClickListener {
                val picker = MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setHour(12)
                    .setMinute(10)
                    .setTitleText("Select Appointment time")
                    .build()

                picker.show(supportFragmentManager, "time")

                picker.addOnPositiveButtonClickListener {
                    timePicker.text = "${picker.hour}:${picker.minute}"
                }
            }

            checkAcc1.setOnCheckedChangeListener { compoundButton, b ->
                Log.d("checkbox", "klik: $b")
            }

            ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
                Log.d("rating", "rating: $fl")
            }
        }
    }
}
