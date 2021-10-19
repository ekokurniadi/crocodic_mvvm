package id.ekokurniadi.myapplication.ui.form.input

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import androidx.fragment.app.DialogFragment
import id.ekokurniadi.myapplication.R

class DialogCustomSaveFragment(val save:(rating:Float)->Unit):DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            val viewDialog =  inflater.inflate(R.layout.dialog_custom,null)

            val buttonSave = viewDialog.findViewById<Button>(R.id.btn_save)
            val buttonCancel = viewDialog.findViewById<Button>(R.id.btn_cancel)
            val ratingBar = viewDialog.findViewById<RatingBar>(R.id.rating_bar)

            buttonCancel.setOnClickListener {
                this.dismiss()
            }
            buttonSave.setOnClickListener {
                val rating = ratingBar.rating
                save(rating)
                this.dismiss()
            }
            builder.setView(viewDialog)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null !")
    }
}