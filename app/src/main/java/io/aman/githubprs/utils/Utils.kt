package io.aman.githubprs.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDate(date: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val outputFormat = SimpleDateFormat("dd-MM-yyyy")
    val date: Date = inputFormat.parse("2018-04-10T04:00:00.000Z")
    return outputFormat.format(date)
}