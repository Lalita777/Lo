package com.example.ya

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user(val service: String, val doctor: String, val date: String, val time: Int) : Parcelable {
}