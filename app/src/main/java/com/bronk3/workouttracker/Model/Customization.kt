package com.bronk3.workouttracker.Model

class Customization(val ExersizeId: Int, val WorkoutId: Int, val timeStamp: String,
                    val id: Int?, val reps: Int?, val sets: Int?, val measurement: Int?, val measurementType: String?) {
    override fun toString(): String {
        return "Id $id, reps $reps, sets: $sets, measurement: $measurement, measurementType: $measurementType, " +
                "ExersizeId: $ExersizeId, WorkoutId: $WorkoutId"
    }
}