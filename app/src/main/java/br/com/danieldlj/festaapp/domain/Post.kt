package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Post(
    val id: Int,
    val what: String,
    val notice: String,
    var date: String,
    var time: String,
    var who: String,
    var description: String,
    var done: Boolean): Parcelable {

    companion object {
        const val KEY = "post-key"
    }
}