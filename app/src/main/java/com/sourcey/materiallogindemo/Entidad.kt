package com.sourcey.materiallogindemo

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by David on 20/02/2018.
 */

class Entidad(val imgFoto: Int, val titutlo: String, private val contenido: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(imgFoto)
        writeString(titutlo)
        writeString(contenido)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Entidad> = object : Parcelable.Creator<Entidad> {
            override fun createFromParcel(source: Parcel): Entidad = Entidad(source)
            override fun newArray(size: Int): Array<Entidad?> = arrayOfNulls(size)
        }
    }
}
