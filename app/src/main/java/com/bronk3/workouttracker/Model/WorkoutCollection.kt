package com.bronk3.workouttracker.Model

import com.bronk3.workouttracker.Utility.*

object WorkoutCollection {

    private var list = ArrayList<Workout>()


    fun createWorkout(name: String, timeStamp: String): Workout {
        val workout = Workout(name, timeStamp)
        list.add(workout)
        return workout
    }

    var abs = createWorkout("Abs", getDateNow())
    var legs = createWorkout("Legs", getDateNow())
    var arms = createWorkout("Arms", getDateNow())
    var back = createWorkout("Back", getDateNow())

    fun list() : ArrayList<Workout> {
        return list
    }

    var absList = listOf(
            CustomizationCollection.create(ExersizeCollection.find("Crunch"), abs),
            CustomizationCollection.create(ExersizeCollection.find("v-situp"), abs),
            CustomizationCollection.create(ExersizeCollection.at(3), abs),
            CustomizationCollection.create(ExersizeCollection.at(2), abs),
                    CustomizationCollection.create(ExersizeCollection.at(5), abs)
    )

    var legsList = listOf(
            CustomizationCollection.create(ExersizeCollection.find("Crunch"), legs),
            CustomizationCollection.create(ExersizeCollection.find("v-situp"), legs),
            CustomizationCollection.create(ExersizeCollection.at(1), legs),
            CustomizationCollection.create(ExersizeCollection.at(2), legs),
            CustomizationCollection.create(ExersizeCollection.at(3), legs)
    )

    var armsList = listOf(
            CustomizationCollection.create(ExersizeCollection.find("Crunch"), arms),
            CustomizationCollection.create(ExersizeCollection.find("v-situp"), arms),
            CustomizationCollection.create(ExersizeCollection.at(3), arms),
            CustomizationCollection.create(ExersizeCollection.at(5), arms),
            CustomizationCollection.create(ExersizeCollection.at(7), arms)
    )

    var backList = listOf(
            CustomizationCollection.create(ExersizeCollection.find("Crunch"), back),
            CustomizationCollection.create(ExersizeCollection.find("v-situp"), back),
            CustomizationCollection.create(ExersizeCollection.at(6), back),
            CustomizationCollection.create(ExersizeCollection.at(4), back),
            CustomizationCollection.create(ExersizeCollection.at(2), back)
    )
}