package com.sourcey.materiallogindemo.Alimentos

import android.os.Parcel
import android.os.Parcelable

class Alimentos(var tipoAlimento: String, var nombreAlimento: String, var cantCalorias: Int, var cantProteinas: Double, var DietaID: Int, var createdAt: Long, var updatedAt: Long) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipoAlimento)
        parcel.writeString(nombreAlimento)
        parcel.writeInt(cantCalorias)
        parcel.writeDouble(cantProteinas)
        parcel.writeInt(DietaID)
        parcel.writeLong(createdAt)
        parcel.writeLong(updatedAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Alimentos> = object : Parcelable.Creator<Alimentos> {
            override fun createFromParcel(source: Parcel): Alimentos = Alimentos(source)
            override fun newArray(size: Int): Array<Alimentos?> = arrayOfNulls(size)
        }
    }
}