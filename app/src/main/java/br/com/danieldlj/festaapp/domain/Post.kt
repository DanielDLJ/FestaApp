package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Post(
    var id: Int,
    var id_party: Int,
    var what: String,
    var notice: String,
    var date: String,
    var who: String,
    var description: String,
    var done: Boolean): Parcelable {

    companion object {
        const val KEY = "post-key"
    }
}