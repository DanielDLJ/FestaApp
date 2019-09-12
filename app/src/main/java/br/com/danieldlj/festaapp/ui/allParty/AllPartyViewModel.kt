package br.com.danieldlj.festaapp.ui.allParty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllPartyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Parties Fragment"
    }
    val text: LiveData<String> = _text
}