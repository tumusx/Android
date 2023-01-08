package com.github.tumusx.maxappmvvm.commons.stateUI

import android.view.View
import com.github.tumusx.maxappmvvm.R
import com.google.android.material.snackbar.Snackbar

fun View.customSnackBar(
    messageSnackbar: String = "",
    durationSnackBar: Int = Snackbar.LENGTH_LONG
) {
    val snackbar = Snackbar.make(this, messageSnackbar, durationSnackBar)
    snackbar.setAction(this.context.getString(R.string.fechar)) { snackbar.dismiss() }
    snackbar.show()
}