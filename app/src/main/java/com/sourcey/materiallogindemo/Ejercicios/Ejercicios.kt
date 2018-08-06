package com.sourcey.materiallogindemo.Ejercicios

import android.os.Parcel
import android.os.Parcelable

class Ejercicios(var tipoEjercicio: String,var createdAt: Long, var updatedAt: Long) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipoEjercicio)
        parcel.writeLong(createdAt)
        parcel.writeLong(updatedAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Ejercicios> = object : Parcelable.Creator<Ejercicios> {
            override fun createFromParcel(source: Parcel): Ejercicios = Ejercicios(source)
            override fun newArray(size: Int): Array<Ejercicios?> = arrayOfNulls(size)
        }
    }
}