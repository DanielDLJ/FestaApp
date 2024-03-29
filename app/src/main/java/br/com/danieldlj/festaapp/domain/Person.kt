package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Person(
    val id: Int,
    val name: String,
    val image: String): Parcelable {

    companion object {
        const val KEY = "person-key"
    }
}
