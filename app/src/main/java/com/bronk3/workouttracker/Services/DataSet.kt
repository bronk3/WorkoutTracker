package com.bronk3.workouttracker.Services

import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Utility.getDate
import java.util.*

object DataSet {

    val exersizes: ArrayList<Exersize> = arrayListOf(
            Exersize(1, "Crunch", "ic_launcher_background"),
            Exersize(2, "v-situp", "ic_launcher_background"),
            Exersize(3, "Squats", "ic_launcher_background"),
            Exersize(4, "Lunges", "ic_launcher_background"),
            Exersize(5, "Tricep dips", "ic_launcher_background"),
            Exersize(6, "Shoulder press", "ic_launcher_background"),
            Exersize(7, "Row", "ic_launcher_background"),
            Exersize(8, "deadlift", "ic_launcher_background"),
            Exersize(9, "Crunch", "ic_launcher_background"),
            Exersize(10, "v-situp", "ic_launcher_background"),
            Exersize(11, "Squats", "ic_launcher_background"),
            Exersize(12, "Lunges", "ic_launcher_background"),
            Exersize(13, "Tricep dips", "ic_launcher_background"),
            Exersize(14, "Shoulder press", "ic_launcher_background"),
            Exersize(15, "Row", "ic_launcher_background"),
            Exersize(16, "deadlift", "ic_launcher_background")
    )

    val workouts: ArrayList<Workout> = arrayListOf(
            Workout(1, "abs", getDate()),
            Workout(2, "legs", getDate()),
            Workout(3, "arms", getDate()),
            Workout(4, "back", getDate())
    )

    val customizations: ArrayList<Customization> = arrayListOf(
            Customization(5, 3, getDate(),1, 8, 3, 25,
                    "lbs"),
            Customization(2, 3, getDate(),2, 8, 3, 25,
                    "lbs"),
            Customization(3, 1, getDate(),3, 10, 2, 25,
                    "lbs"),
            Customization(4, 1, getDate(),4, 8, 3, 25,
                    "lbs"),
            Customization(5, 2, getDate(),5, 15, 7, 25,
                    "lbs"),
            Customization(6, 2, getDate(),6, 8, 3, 25,
                    "lbs"),
            Customization(7, 2, getDate(),7, 12, 1, 25,
                    "lbs"),
            Customization(8, 4, getDate(),8, 8, 3, 25,
                    "lbs")
    )
    

}