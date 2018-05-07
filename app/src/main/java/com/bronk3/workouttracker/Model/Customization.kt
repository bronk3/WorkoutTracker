package com.bronk3.workouttracker.Model

class Customization(val ExersizeId: Int, val WorkoutId: Int, var timeStamp: String,
                    var id: Int?, var reps: Int?, var sets: Int?, var measurement: Int?, var measurementType: String?) {
    override fun toString(): String {
        return "Id $id, reps $reps, sets: $sets, measurement: $measurement, measurementType: $measurementType, " +
                "ExersizeId: $ExersizeId, WorkoutId: $WorkoutId"
    }

    override fun equals(other: Any?): Boolean {
        val other = other as Customization
        if (other?.id == this.id)
            return true
        return false
    }

    fun updateTo(customization: Customization) {
        this.timeStamp = customization?.timeStamp
        this.reps = customization?.reps
        this.sets = customization?.sets
        this.measurement = customization?.measurement
        this.measurementType = customization?.measurementType
    }
}