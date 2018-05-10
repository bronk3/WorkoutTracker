package com.bronk3.workouttracker.Utility

import java.text.SimpleDateFormat
import java.util.*

const val WORKOUT = "Workout"
const val EXERSIZE_LIST = "Exersize list"

fun getDateNow(): String {
    //MMM d, HH:mm
    return SimpleDateFormat("d/M/yy a").format(Date())
}
