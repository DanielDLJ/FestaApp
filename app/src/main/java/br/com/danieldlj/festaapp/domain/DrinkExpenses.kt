package br.com.danieldlj.festaapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DrinkExpenses(
    val id: Int,
    val item: String,
    var image:String,
    var qtdByPerson:Float, //Qdd/pessoa (L)
    var qtdProvided:Float, //Quantidade PREVISTA (em L) -> (Calculado)
    var used:Float,
    var priceLiter:Float,
    var total:Float, //qtdProvided * priceLiter (calculado)
    var provider:String,
    var cups:Float, //quantidade de copos
    var allBar:Float, //=((qtdProvided * 1000) / Quantidade de Pessoas) * cups    VALOR TOTAL DE VENDA DE TODO BAR (calculado)
    val paid: Boolean): Parcelable {

    companion object {
        const val KEY = "drink-expenses-key"
    }
}


/*
Calculados
    litros/pessoa = SUM(qtdByPerson)
    TOTAL = SUM(total)
    TOTAL VENDA DE BEBIDAS = SUM(allBar)
    VENDA DE BEBIDAS DO ROLE  - COMPRAS DE BEBIDAS =  TOTAL VENDA DE BEBIDAS - TOTAL
 */
