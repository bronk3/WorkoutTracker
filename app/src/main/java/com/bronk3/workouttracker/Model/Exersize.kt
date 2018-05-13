package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable
import java.util.*


class Exersize(var name: ExersizeId,
               var image: String,
               var reps: Int,
               var sets: Int,
               var measure: Int,
               var measureType: MeasurementTypes
)
    : Parcelable {

    var workoutSetState: BooleanArray = BooleanArray(sets) { _ -> false }
    var Id: Int = -1
    lateinit var finishTime: String
    var complete: Int = 0

    constructor(parcel: Parcel) : this(
            ExersizeId.values()[parcel.readInt()],
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            MeasurementTypes.values()[parcel.readInt()]
            ) {
        parcel.readBooleanArray(workoutSetState)
        parcel.readInt()
        parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(name.ordinal)
        parcel.writeString(image)
        parcel.writeInt(reps)
        parcel.writeInt(sets)
        parcel.writeInt(measure)
        parcel.writeInt(measureType.ordinal)
        parcel.writeBooleanArray(workoutSetState)
        parcel.writeInt(Id)
        parcel.writeInt(complete)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun update(updateExersize: Exersize) {
        this.reps = updateExersize.reps
        this.sets = updateExersize.sets
        this.measure = updateExersize.measure
        this.measureType = updateExersize.measureType
        this.workoutSetState = BooleanArray(updateExersize.sets) { _ -> false }
    }

    fun reset() {
        this.workoutSetState = BooleanArray(this.sets) { _ -> false }
        this.complete = 0
    }

    override fun toString(): String {
        return "$Id,: $name,: $image,: $reps,: $sets,: $measure,: ${measureType.toString()}:, ${workoutSetState.toString()}||"
    }

    companion object CREATOR : Parcelable.Creator<Exersize> {

        override fun createFromParcel(parcel: Parcel): Exersize {
            return Exersize(parcel)
        }

        override fun newArray(size: Int): Array<Exersize?> {
            return arrayOfNulls(size)
        }
    }
}