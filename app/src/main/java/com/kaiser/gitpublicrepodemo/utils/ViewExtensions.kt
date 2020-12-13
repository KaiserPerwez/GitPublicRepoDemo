package com.kaiser.gitpublicrepodemo.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar

fun View?.showSnackbar(message: String) {
    Snackbar.make(this!!, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Okay") {
            snackbar.dismiss()
        }
    }.show()
}


fun Activity?.dismissKeyboard() {
    val inputMethodManager = this?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (this.currentFocus !=null)
        inputMethodManager.hideSoftInputFromWindow(
            this.currentFocus!!
                .applicationWindowToken, 0
        )
}

