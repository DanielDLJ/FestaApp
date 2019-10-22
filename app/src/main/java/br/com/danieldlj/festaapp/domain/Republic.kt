package br.com.danieldlj.festaapp.domain

class Republic(
    val id: Int,
    val name: String,
    val image: String,
    var isExpanded: Boolean? = false,
    var residents: List<Resident>)
