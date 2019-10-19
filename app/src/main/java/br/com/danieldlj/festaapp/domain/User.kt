package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(
    val name: String,
    val image: Int,
    val partyName: String) : Parcelable {

    companion object {
        const val KEY = "user-key"
    }
}
