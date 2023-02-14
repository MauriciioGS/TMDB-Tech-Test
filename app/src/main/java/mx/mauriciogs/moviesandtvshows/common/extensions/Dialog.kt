package mx.mauriciogs.moviesandtvshows.common.extensions

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.Fragment
import mx.mauriciogs.moviesandtvshows.R

fun Fragment.loadingDialog(): Dialog {
    val progressDialog = Dialog(requireContext(), R.style.FullScreenDialog)
    progressDialog.let {
        it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        it.setContentView(R.layout.loading_dialog)
        it.setCancelable(false)
        it.setCanceledOnTouchOutside(false)
        it.show()
        return it
    }
}