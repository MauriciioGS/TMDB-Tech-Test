package mx.mauriciogs.moviesandtvshows.common.extensions

import android.app.Activity
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import mx.mauriciogs.moviesandtvshows.R

fun Fragment.snackbar(text: CharSequence?, duration: Int = Snackbar.LENGTH_SHORT) =
    Snackbar.make(requireView(), text ?: "", duration).apply { show() }

fun Fragment.snackbar(@StringRes resId: Int, duration: Int = Snackbar.LENGTH_SHORT) =
    Snackbar.make(requireView(), resId, duration).apply { show() }

fun Activity.snackbar(text: CharSequence?, duration: Int = Snackbar.LENGTH_SHORT) =
    Snackbar.make(findViewById(android.R.id.content), text ?: "", duration).apply { show() }

fun Activity.snackbar(@StringRes resId: Int, duration: Int = Snackbar.LENGTH_SHORT) =
    Snackbar.make(findViewById(android.R.id.content), resId, duration).apply { show() }

fun Snackbar.showError() = apply { view.setBackgroundResource(R.color.error) }