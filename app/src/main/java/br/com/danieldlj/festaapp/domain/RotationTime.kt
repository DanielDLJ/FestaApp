package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RotationTime(
    val timeStart: String,
    val timeTo: String,
    var persons: List<Person>): Parcelable {

    companion object {
        const val KEY = "rotation-time-key"
    }

}
