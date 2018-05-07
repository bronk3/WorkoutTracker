package com.bronk3.workouttracker.Services

import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Utility.getDate
import java.util.*

object DataSet {

    val exersizes: ArrayList<Exersize> = arrayListOf(
            Exersize(1, "Crunch", "filter", listOf( "min", "sec", "N/A")),
            Exersize(2, "v-situp", "filter_data", listOf( "min", "sec", "N/A")),
            Exersize(3, "Squats", "focus_group", listOf( "min", "sec", "kg", "Lbs", "N/A")),
            Exersize(4, "Lunges", "front_desk", listOf( "min", "sec", "kg", "Lbs", "N/A")),
            Exersize(5, "Tricep dips", "multimple_solutions", listOf( "min", "sec", "kg", "Lbs", "N/A")),
            Exersize(6, "Shoulder press", "oil", listOf("kg", "Lbs")),
            Exersize(7, "Row", "plastic_bottle", listOf("kg", "Lbs")),
            Exersize(8, "run", "positioning", listOf("miles", "km")),
            Exersize(9, "Box Jump", "service_waste_disposal", listOf("feet", "meters")),
            Exersize(10, "Sprint", "solution", listOf("miles", "km", "min", "sec")),
            Exersize(11, "mountain climber", "solution2", listOf("min", "sec")),
            Exersize(12, "Lunges", "stats_histogram",listOf("N/A", "min", "sec", "kg", "Lbs")),
            Exersize(13, "Tricep dips", "stats_pie_chart",listOf("N/A", "min", "sec", "kg", "Lbs")),
            Exersize(14, "Shoulder press", "stock_market", listOf( "min", "sec", "kg", "Lbs", "N/A")),
            Exersize(15, "Row", "task", listOf( "min", "sec", "kg", "Lbs", "N/A")),
            Exersize(16, "deadlift", "trophy", listOf( "min", "sec", "kg", "Lbs", "N/A"))
    )

    val workouts: ArrayList<Workout> = arrayListOf(
            Workout(1,1, "abs", getDate()),
            Workout(1,2, "legs", getDate()),
            Workout(1,3, "arms", getDate()),
            Workout(1,4, "back", getDate())
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