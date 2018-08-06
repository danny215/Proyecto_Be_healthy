package com.sourcey.materiallogindemo.Rutinas

import android.os.Parcel
import android.os.Parcelable

class Rutina(var fechaRegistro: String, var peso: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(parcel: Parcel, flags: Int){
        parcel.writeString(fechaRegistro)
        parcel.writeInt(peso)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Rutina> = object : Parcelable.Creator<Rutina> {
            override fun createFromParcel(source: Parcel): Rutina = Rutina(source)
            override fun newArray(size: Int): Array<Rutina?> = arrayOfNulls(size)
        }
    }
}