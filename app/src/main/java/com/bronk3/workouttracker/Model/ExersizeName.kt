package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable

enum class ExersizeId(val Name: String): Parcelable {
    CRUNCH("CRUNCH"),
    VSIT("V-sit"),
    SQUAT("Squat"),
    DIPS("Dips"),
    TRICEPDIP("Tricep Dip"),
    LUNGE("Lunge"),
    BENCHPRESS("Bench Press"),
    PUSHUP("Push up");

    constructor(parcel: Parcel) : this(parcel.readString()) {
        parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExersizeId> {
        override fun createFromParcel(parcel: Parcel): ExersizeId {
            return ExersizeId.values()[parcel.readInt()]
        }

        override fun newArray(size: Int): Array<ExersizeId?> {
            return arrayOfNulls(size)
        }
    }
}