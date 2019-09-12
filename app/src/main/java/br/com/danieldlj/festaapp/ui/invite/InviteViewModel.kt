package br.com.danieldlj.festaapp.ui.invite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InviteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is invite Fragment"
    }
    val text: LiveData<String> = _text
}