package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable

class Workout(val id: Int, var name: String, var timeStamp: String)
{
    override fun toString(): String {
        return "Id $id, Name: $name, TimeStamp: $timeStamp"
    }
}

//    : Parcelable {
//
//    override fun writeToParcel(dest: Parcel?, flags: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun describeContents(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}