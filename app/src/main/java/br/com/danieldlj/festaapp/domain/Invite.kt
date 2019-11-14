package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Invite(
    val id: Int,
    val name: String,
    var valor:Float,
    var expectedSales:Int,
    var total:Float,
    var student: Boolean): Parcelable {

    companion object {
        const val KEY = "invite-key"
    }
}