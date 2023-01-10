package com.github.tumusx.maxappmvvm.commons.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.redirectUser(): Boolean {
    return try {
        val connectivityManager: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: Network? = connectivityManager.activeNetwork
        networkInfo != null
    } catch (exception: Exception) {
        exception.printStackTrace()
        false
    }
}
