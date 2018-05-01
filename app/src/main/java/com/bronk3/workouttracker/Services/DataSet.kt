package com.bronk3.workouttracker.Services

import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.Workout
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DataSet {

    val exersizes: ArrayList<Exersize> = arrayListOf(
            Exersize(1, "Crunch", "Crunch"),
            Exersize(2, "v-situp", "v-situp"),
            Exersize(3, "Squats", "Squats"),
            Exersize(4, "Lunges", "Lunges"),
            Exersize(5, "Tricep dips", "Tricep dips"),
            Exersize(6, "Shoulder press", "Shoulder press"),
            Exersize(7, "Row", "Row"),
            Exersize(8, "deadlift", "deadlift")
    )

    val workouts: ArrayList<Workout> = arrayListOf(
            Workout(1, "abs", getDate()),
            Workout(2, "legs", getDate()),
            Workout(3, "arms", getDate()),
            Workout(4, "back", getDate())
    )

    val customizations: ArrayList<Customization> = arrayListOf(
            Customization(1, 8, 3, 25,
                    "lbs", 5, 3, getDate()),
            Customization(2, 8, 3, 25,
                    "lbs", 2, 3, getDate()),
            Customization(3, 10, 2, 25,
                    "lbs", 3, 1, getDate()),
            Customization(4, 8, 3, 25,
                    "lbs", 4, 1, getDate()),
            Customization(5, 15, 7, 25,
                    "lbs", 5, 2, getDate()),
            Customization(6, 8, 3, 25,
                    "lbs", 6, 2, getDate()),
            Customization(7, 12, 1, 25,
                    "lbs", 7, 2, getDate()),
            Customization(8, 8, 3, 25,
                    "lbs", 8, 4, getDate())
    )
    
    fun getDate(): String {
        return SimpleDateFormat("MMM d, HH:mm").format(Date())
    }
}