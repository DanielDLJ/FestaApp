package br.com.danieldlj.festaapp.ui.list_rep

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListRepViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is List Rep Fragment"
    }
    val text: LiveData<String> = _text
}