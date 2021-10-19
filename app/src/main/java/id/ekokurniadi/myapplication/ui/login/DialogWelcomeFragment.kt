package id.ekokurniadi.myapplication.ui.login

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import id.ekokurniadi.myapplication.R

class DialogWelcomeFragment(val name: String, val login:() -> Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Selamat datang $name")
                .setPositiveButton("OK") { dialog, id ->
                    login()
                }
                .setNegativeButton(R.string.button_cancel) { dialog, id ->
                    // User cancelled the dialog
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}