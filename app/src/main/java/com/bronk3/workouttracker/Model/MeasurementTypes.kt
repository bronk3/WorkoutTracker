package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable
import java.util.*
import kotlin.collections.ArrayList

enum class MeasurementTypes(val type:String) : Parcelable {
    NA("N/A"),
    KG("KG"),
    LBS("Lbs"),
    MIN("Min"),
    SEC("Sec"),
    MI("Miles"),
    KM("KM");

    constructor(parcel: Parcel) : this(parcel.readString()) {
        parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MeasurementTypes> {

        fun toStringArray(): ArrayList<String> {
            var arr = ArrayList<String>()
            for(measurement in MeasurementTypes.values()) {
                arr.add(measurement.type)
            }
            return arr
        }

        override fun createFromParcel(parcel: Parcel): MeasurementTypes {
            return MeasurementTypes.values()[parcel.readInt()]
        }

        override fun newArray(size: Int): Array<MeasurementTypes?> {
            return arrayOfNulls(size)
        }
    }
}