package br.com.danieldlj.festaapp.domain

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Rotation(
    var id: Int,
    val name: String,
    var rotationList: List<RotationTime>): Parcelable {

    companion object {
        const val KEY = "rotation-key"
        const val POSITION = "position-key"
    }

    fun Parcel.createRotationTimeList() : List<RotationTime> {
        val size = rotationList.size
        val output = ArrayList<RotationTime>(size)
        for (i in 0 until size) {
            output.add(rotationList[i])
        }
        return output
    }
}