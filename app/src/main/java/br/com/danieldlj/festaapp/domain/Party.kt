package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Party(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("tet_color")
    var textColor:String,
    @SerializedName("image")
    val image: String): Parcelable {

    companion object {
        const val KEY = "party-key"
    }
}
