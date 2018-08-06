package com.sourcey.materiallogindemo.Nutricion

import android.os.Parcel
import android.os.Parcelable

class Dieta(var tipoAlimento: String, var createdAt: Long, var updatedAt: Long) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(parcel: Parcel, flags: Int){
        parcel.writeString(tipoAlimento)
        parcel.writeLong(createdAt)
        parcel.writeLong(updatedAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Dieta> = object : Parcelable.Creator<Dieta> {
            override fun createFromParcel(source: Parcel): Dieta = Dieta(source)
            override fun newArray(size: Int): Array<Dieta?> = arrayOfNulls(size)
        }
    }
}