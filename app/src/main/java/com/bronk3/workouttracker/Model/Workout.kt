package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable


class Workout (var name: String, var timeStamp: String) : Parcelable
{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(timeStamp)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Name: $name, TimeStamp: $timeStamp"
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