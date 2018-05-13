package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable
import com.bronk3.workouttracker.Utility.getDateNow


class Workout
(var name: String?,
 var timeStamp: String?,
 var ExersizeList: ArrayList<Exersize>?)
    : Parcelable
{
    var Id: Int = -1

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(timeStamp)
        parcel.writeTypedList(ExersizeList)
        parcel.writeInt(Id)
    }

    constructor(parcel: Parcel) : this (
            parcel.readString(),
            parcel.readString(),
            ArrayList()) {
        parcel.readTypedList(this.ExersizeList, Exersize.CREATOR)
        parcel.readInt()
    }

    override fun toString(): String {
        return "$name, $timeStamp, ${ExersizeList.toString()}"
    }

    override fun describeContents(): Int {
        return 0
    }

    fun saveToHistory() {
        for(exersize in this.ExersizeList!!) {
            ExersizeCollection.saveToHistory(exersize)
        }
        this.timeStamp = getDateNow()
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