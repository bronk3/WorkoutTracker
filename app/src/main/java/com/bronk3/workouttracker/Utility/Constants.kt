package com.bronk3.workouttracker.Utility

import android.os.Build.VERSION_CODES.M
import com.bronk3.workouttracker.Model.Customization
import com.bronk3.workouttracker.Model.Exersize
import com.bronk3.workouttracker.Model.Workout
import com.bronk3.workouttracker.Services.DataSet
import java.text.SimpleDateFormat
import java.util.*


val WORKOUT_ID = "workout_id"
val EXERSIZE_ID_LIST = "exersize_id_list"

fun getWorkoutById(id: Int): Workout {
    for (workout in DataSet.workouts) {
        if (workout.id == id) {
            return workout
        }
    }
    return Workout(0, 0, "0", "0")
}

fun getCustomizationByWorkoutId(id: Int): ArrayList<Customization> {
    val customizationList = ArrayList<Customization>()
    for(customization in DataSet.customizations) {
        if(customization.WorkoutId == id) {
            customizationList.add(customization)
        }
    }
    return customizationList
}

fun getDate(): String {
    //MMM d, HH:mm
    return SimpleDateFormat("d/M/yy a").format(Date())
}

fun createWorkout(name: String, timestamp: String): Int {
    val id = DataSet.workouts.count()+1
    DataSet.workouts.add(Workout(1, id ,name, timestamp))
    return id
}

fun getExersizeById(id: Int): Exersize? {
    for (exersize in DataSet.exersizes) {
        if(exersize.id == id) {
            return exersize
        }
    }
    return null
}

fun createCustomizationListByExerciseIds(workoutId: Int, exersizeIds: ArrayList<Int>) : ArrayList<Customization> {
    val customExersizeList = ArrayList<Customization>()
    var index = 1
    for(selectedId in exersizeIds) {
        for (exersize in DataSet.exersizes) {
            if(selectedId == exersize.id) {
                customExersizeList.add(
                        Customization(exersize.id, workoutId, getDate(),
                                DataSet.customizations.count() + index, null, null, null, null))
                continue
            }
        }
        index++
    }
    DataSet.customizations.addAll(customExersizeList)
    return customExersizeList
}

fun updateCustomizations(customizations: ArrayList<Customization>): Unit {
    for(customization in customizations) {
        for (dataCustomization in DataSet.customizations) {
            if(dataCustomization.equals(customization)){
                dataCustomization.updateTo(customization)
            }
        }
    }
}