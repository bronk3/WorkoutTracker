package com.bronk3.workouttracker.Utility

import java.text.SimpleDateFormat
import java.util.*

const val WORKOUT = "Workout"
const val WORKOUT_ID = "Workout Id"
const val EXERSIZE_LIST = "Exersize List"

fun getDateNow(): String {
    //MMM d, HH:mm
    return SimpleDateFormat("d/M/yy a").format(Date())
}
