package com.bronk3.workouttracker.Model

import android.os.Parcel
import android.os.Parcelable

class Customization(val exersize: Exersize, val workout: Workout, 
                    timeStamp: String?, reps: Int?, sets: Int?, 
                    measurement: Int?, measurementType: MeasurementTypes?) : Parcelable {

    val name: String
    val image: String
    var reps: Int
    var setNumber: Int = 0
    set(value) {
        this.sets = BooleanArray(value, { _ -> false})
    }
    var sets: BooleanArray
    var measurement: Int
    var measurementType: MeasurementTypes
    var timeStamp: String?

    constructor(parcel: Parcel) : this(
            parcel.readParcelable(com.bronk3.workouttracker.Model.Exersize::class.java.classLoader),
            parcel.readParcelable(com.bronk3.workouttracker.Model.Workout::class.java.classLoader),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readParcelable<MeasurementTypes>(MeasurementTypes.javaClass.classLoader)) {
        timeStamp = parcel.readString()
        reps = parcel.readInt()
        setNumber = parcel.readInt()
        sets = parcel.createBooleanArray()
        measurement = parcel.readInt()
        measurementType = parcel.readParcelable(MeasurementTypes::class.java.classLoader)
    }

    init {
        this.name = exersize.name
        this.image = exersize.image
        this.reps = reps!!.or(exersize.defaultReps)
        this.setNumber = sets!!or(exersize.defaultSets)
        this.sets = BooleanArray(sets!!.or(exersize.defaultSets),{ _ -> false})
        this.measurement = measurement!!.or(exersize.defaultMeasure)
        this.measurementType = measurementType ?: exersize.defaultMeasureType
        this.timeStamp = timeStamp ?: workout.timeStamp
    }


    override fun toString(): String {
        return "reps $reps, sets: $sets, measurement: $measurement, measurementType: $measurementType, " +
                "ExersizeId: $Exersize"
    }

    fun setCustomization(customization: Customization) {
        this.reps = reps!!.or(exersize.defaultReps)
        this.setNumber = customization.setNumber
        this.sets = BooleanArray(customization.setNumber, { _ -> false})
        this.measurement = customization.measurement
        this.measurementType = customization.measurementType
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(exersize, flags)
        parcel.writeParcelable(workout, flags)
        parcel.writeInt(reps)
        parcel.writeInt(setNumber)
        parcel.writeBooleanArray(sets)
        parcel.writeInt(measurement)
        parcel.writeParcelable(measurementType, flags)
        parcel.writeString(timeStamp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Customization> {
        override fun createFromParcel(parcel: Parcel): Customization {
            return Customization(parcel)
        }

        override fun newArray(size: Int): Array<Customization?> {
            return arrayOfNulls(size)
        }
    }
}