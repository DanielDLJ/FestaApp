package br.com.danieldlj.festaapp.uitl

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
private var TAG = "Uitl"

private fun EditText.afterTextChanged(invokeValidation: (String) -> Unit ){

    this.addTextChangedListener( object: TextWatcher {

        override fun afterTextChanged( content: Editable? ) {
            invokeValidation( content.toString() )
        }

        override fun beforeTextChanged(content: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(content: CharSequence?, start: Int, before: Int, count: Int) {}
    } )
}



fun EditText.validate(validator: (String) -> Boolean, message: String ){

    this.afterTextChanged {
        this.error =
            if( validator(it) )
                null
            else
                message
    }
}



@SuppressLint("SimpleDateFormat")
fun String.isValidDate(): Boolean{
    val dobString = this.toString()
    val df = SimpleDateFormat("dd/MM/yyyy")
    df.isLenient = false


    val pattern = "[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}".toRegex()
    if (!pattern.containsMatchIn(this)) {
        return false
    }

    try {
        val date: Date = df.parse(dobString)
        Log.d(TAG,"Legal Date $date")
        return true
    } catch (e: ParseException){
        Log.d(TAG,"NOT Legal Date")
        return false
    }
    return false
}

@SuppressLint("SimpleDateFormat")
fun String.isValidHour(): Boolean{
    val dobString = this
    val df = SimpleDateFormat("HH:mm")
    df.isLenient = false


    val pattern = "[0-9]{2}(:|-)[0-9]{2}".toRegex()
    if (!pattern.containsMatchIn(this)) {
        return false
    }

    try {
        val date: Date = df.parse(dobString)
        Log.d(TAG,"Legal Hour $date")
        return true
    } catch (e: ParseException){
        Log.d(TAG,"NOT Legal Hour")
        return false
    }
    return false
}


fun String.isValidEmail() : Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher( this ).matches()

fun String.isValidPassword() : Boolean = this.length > 5

fun String.isValidString() : Boolean = this.length > 3

/*
 * A seguir códigos de validação de CPF e CNPJ.
 *
 * Fontes:
 *      Código: https://www.vivaolinux.com.br/script/Codigo-para-validar-CPF-e-CNPJ-otimizado
 *      Explicação: https://www.geradorcpf.com/algoritmo_do_cpf.htm
 * */

private val weightCPF = intArrayOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
private val weightCNPJ = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

fun String.isValidCPF() : Boolean {
    if( this.length != 11 )
        return false

    val digit1 = digitCalc( this.substring(0, 9), weightCPF )
    val digit2 = digitCalc(this.substring(0, 9) + digit1, weightCPF )

    return this == (this.substring(0, 9) + digit1.toString() + digit2.toString())
}

fun String.isValidCNPJ() : Boolean {
    if( this.length != 14 )
        return false

    val digit1 = digitCalc( this.substring(0, 12), weightCNPJ )
    val digit2 = digitCalc( this.substring(0, 12) + digit1, weightCNPJ )

    return this == (this.substring(0, 12) + digit1.toString() + digit2.toString())
}


@SuppressLint("SimpleDateFormat")
fun String.getDate() : String {
    val parser =  SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val formattedDate = formatter.format(parser.parse(this))
    return formattedDate
}

@SuppressLint("SimpleDateFormat")
fun String.getTime() : String {
    val parser =  SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val formatter = SimpleDateFormat("HH:mm")
    val formattedDate = formatter.format(parser.parse(this))
    return formattedDate
}

@SuppressLint("SimpleDateFormat")
fun String.getDateTimeBD() : String {
    val parser =  SimpleDateFormat("dd/MM/yyyy HH:mm")
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val formattedDate = formatter.format(parser.parse(this))
    return formattedDate
}

private fun digitCalc(
    str: String,
    weight: IntArray ): Int {

    var sum = 0
    var index = str.length - 1
    var digit: Int

    while (index >= 0) {
        digit = Integer.parseInt( str.substring(index, index + 1) )
        sum += digit * weight[ weight.size - str.length + index ]
        index--
    }

    sum = 11 - sum % 11

    return if(sum > 9)
        0
    else
        sum
}