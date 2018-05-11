//package com.gnychis.coexisyst
//
//import java.util.ArrayList
//
//import android.os.Parcel
//import android.os.Parcelable
//
//class ZigBeeDev() : Parcelable {
//    constructor(parcel: Parcel) : this() {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<ZigBeeDev> {
//        override fun createFromParcel(parcel: Parcel): ZigBeeDev {
//            return ZigBeeDev(parcel)
//        }
//
//        override fun newArray(size: Int): Array<ZigBeeDev?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
//
//class ZigBeeNetwork private constructor(`in`: Parcel) : Parcelable {
//
//    var _mac: String             // the source address (of the coordinator?)
//    var _pan: String             // the network address
//    var _band: Int = 0               // the channel
//    internal var _lqis: ArrayList<Int>       // link quality indicators (to all devices?)
//    var _devices = ArrayList<ZigBeeDev>()  // the devices in the network
//
//    override fun writeToParcel(out: Parcel, flags: Int) {
//        out.writeString(_mac)
//        out.writeString(_pan)
//        out.writeInt(_band)
//        out.writeSerializable(_lqis)
//        out.writeTypedList(_devices)  // help here
//    }
//
//    init {
//        _mac = `in`.readString()
//        _pan = `in`.readString()
//        _band = `in`.readInt()
//        _lqis = `in`.readSerializable() as ArrayList<Int>
//        `in`.readTypedList(_devices, ZigBeeDev.CREATOR) // Should work now
//
//    }
//
//    override fun describeContents(): Int {
//        return this.hashCode()
//    }
//
//    companion object {
//
//        val CREATOR: Parcelable.Creator<ZigBeeNetwork> = object : Parcelable.Creator<ZigBeeNetwork> {
//            override fun createFromParcel(`in`: Parcel): ZigBeeNetwork {
//                return ZigBeeNetwork(`in`)
//            }
//
//            override fun newArray(size: Int): Array<ZigBeeNetwork> {
//                return arrayOfNulls(size)!!
//            }
//        }
//    }
//
//    //...
//}