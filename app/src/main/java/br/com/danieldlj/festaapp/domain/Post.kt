package br.com.danieldlj.festaapp.domain

class Post(
    val id: Int,
    val what: String,
    val notice: String,
    var date: String,
    var time: String,
    var who: String,
    var description: String,
    var done: Boolean)