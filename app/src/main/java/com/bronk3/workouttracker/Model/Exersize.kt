package com.bronk3.workouttracker.Model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Exersize(val name: String, val image: String,
               measurementTypes: Array<MeasurementTypes>?,
               val defaultReps: Int, val defaultSets: Int,
               val defaultMeasure: Int, val defaultMeasureType: MeasurementTypes) : Parcelable {

    lateinit var measurementTypes: Array<MeasurementTypes>

    init {
        // ALl MEASUREMENT TYPES
        this.measurementTypes = measurementTypes ?: MeasurementTypes.values()
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelableArray(MeasurementTypes.javaClass.classLoader),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readParcelable<MeasurementTypes>(MeasurementTypes.javaClass.classLoader)
    ) {

    }

    override fun equals(other: Any?): Boolean {
        val name = other as String
        return this.name == name
    }

    override fun toString(): String {
        return "\t Name: $name,\t Image: $image, Types: $measurementTypes"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeParcelableArray(measurementTypes, flags)
        parcel.writeInt(defaultReps)
        parcel.writeInt(defaultSets)
        parcel.writeInt(defaultMeasure)
        parcel.writeParcelable(defaultMeasureType, flags)
    }

    override fun describeContents(): Int {
        return 0
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