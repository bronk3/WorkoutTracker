package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

enum class MeasurementTypes() : Parcelable {
    NA,
    KG,
    LBS,
    MIN,
    SEC,
    MI,
    KM;

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(this.ordinal)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<MeasurementTypes> {

        override fun createFromParcel(parcel: Parcel): MeasurementTypes {
            return MeasurementTypes.values()[parcel.readInt()]
        }

        override fun newArray(size: Int): Array<MeasurementTypes> {
            return MeasurementTypes.values()
        }

        fun stringArray(measurementTypesArray: Array<MeasurementTypes>?): Array<String> {
            var measurementTypesArray = measurementTypesArray ?: MeasurementTypes.values()
                val stringArray = Array<String>(measurementTypesArray.count(), { int ->
                    measurementTypesArray[int].name
                })
            return stringArray
        }
    }
}