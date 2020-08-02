package com.andra.tugas_intent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParcelName(val nama: String, val umur: Int) : Parcelable