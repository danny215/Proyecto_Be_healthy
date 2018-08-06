package com.sourcey.materiallogindemo.DetalleEjercicio

import android.os.Parcel
import android.os.Parcelable

class DetalleEjercicios(var tipoEjercicio: String, var nombreEjercicio: String, var descripcionEjercicio: String, var rutinaId: Int, var createdAt: Long, var updatedAt: Long) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipoEjercicio)
        parcel.writeString(nombreEjercicio)
        parcel.writeString(descripcionEjercicio)
        parcel.writeInt(rutinaId)
        parcel.writeLong(createdAt)
        parcel.writeLong(updatedAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DetalleEjercicios> = object : Parcelable.Creator<DetalleEjercicios> {
            override fun createFromParcel(source: Parcel): DetalleEjercicios = DetalleEjercicios(source)
            override fun newArray(size: Int): Array<DetalleEjercicios?> = arrayOfNulls(size)
        }
    }
}