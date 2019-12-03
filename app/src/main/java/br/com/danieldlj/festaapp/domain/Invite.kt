package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Invite(
    val id: Int,
    var id_party: Int,
    var name: String,
    var valor:Float,
    var expectedSales:Int,
    var total:Float, //Calculado expectedSales * valor
    @SerializedName("student")
    var student: Int): Parcelable {

    companion object {
        const val KEY = "invite-key"
    }
}