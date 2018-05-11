package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable


class Exersize(var name: ExersizeId,
               var image: String,
               var reps: Int,
               var sets: Int,
               var measure: Int,
               var measureType: MeasurementTypes)
    : Parcelable {


    constructor(parcel: Parcel) : this(
            parcel.readParcelable<ExersizeId>(ExersizeId.javaClass.classLoader),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readParcelable(MeasurementTypes::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(name, flags)
        parcel.writeString(image)
        parcel.writeInt(reps)
        parcel.writeInt(sets)
        parcel.writeInt(measure)
        parcel.writeParcelable(measureType, flags)
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