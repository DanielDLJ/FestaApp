package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class FixedExpenses(
    val id: Int,
    val item: String,
    var price:Float,
    val paid: Boolean): Parcelable {

    companion object {
        const val KEY = "fixed-expenses-key"
    }
}
