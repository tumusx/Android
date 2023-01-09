package com.github.tumusx.maxappmvvm.commons.extension

import android.annotation.SuppressLint
import java.sql.Date
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun simpleDateFormat(dtA: String): String {
    return try {
        val format = SimpleDateFormat("MMdd")
        val data = format.parse(dtA)?.let { Date(it.time) }
        data.toString()
    } catch (exception: IllegalArgumentException) {
        exception.printStackTrace()
        ""
    }
}

class DateFormat {

    private val monthList = mutableListOf<Pair<String, String>>()
    private fun months(): List<Pair<String, String>> {
        monthList.add(Pair("Jan", "01"))
        monthList.add(Pair("Fev", "02"))
        monthList.add(Pair("Mar", "03"))
        monthList.add(Pair("Abr", "04"))
        monthList.add(Pair("Mai", "05"))
        monthList.add(Pair("Jun", "06"))
        monthList.add(Pair("Jul", "07"))
        monthList.add(Pair("Ago", "08"))
        monthList.add(Pair("Set", "09"))
        monthList.add(Pair("Out", "10"))
        monthList.add(Pair("Nov", "11"))
        monthList.add(Pair("Dez", "12"))
        return monthList
    }

    fun searchMonth(mountNumber: String): String {
        for (monthItem in months()) {
            if (monthItem.second == mountNumber) {
                return monthItem.first
            }
        }
        return months()[10].first
    }

}