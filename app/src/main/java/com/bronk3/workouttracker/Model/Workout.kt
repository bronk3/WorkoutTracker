package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable


class Workout
        (var name: String,
        var timeStamp: String,
        var ExersizeList: ArrayList<Exersize>)
    : Parcelable
{
    init {
        ExersizeList = ArrayList()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(timeStamp)
        parcel.readTypedList(ExersizeList, Exersize.CREATOR)
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readTypedList(ExersizeList, Exersize.CREATOR)
    ) {}

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Workout> {
        override fun createFromParcel(parcel: Parcel): Workout {
            return Workout(parcel)
        }

        override fun newArray(size: Int): Array<Workout?> {
            return arrayOfNulls(size)
        }
    }

}