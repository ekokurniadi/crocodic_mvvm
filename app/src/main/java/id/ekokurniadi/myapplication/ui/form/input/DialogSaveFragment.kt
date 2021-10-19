package id.ekokurniadi.myapplication.ui.form.input

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogSaveFragment(val save:()->Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)

            builder.setMessage("Apakah anda yakin ?")
                .setPositiveButton("Simpan") { dialog, id ->
                    save()
                }
                .setNegativeButton("Batal") { dialog, id ->
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null !")
    }
}