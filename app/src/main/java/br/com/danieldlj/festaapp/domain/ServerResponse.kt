package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ServerResponse(

    val created: Int,// last_isert_id ou 0 caso errado
    val updated: Boolean, //1 | 0 (1 caso de certo e 0 caso de algo errado)
    var deleted: Boolean //1 | 0 (1 caso de certo e 0 caso de algo errado)
                ): Parcelable {

    companion object {
        const val KEY = "server-response-key"
    }
}