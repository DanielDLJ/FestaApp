package br.com.danieldlj.festaapp.ui.rotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RotationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rotation Fragment"
    }
    val text: LiveData<String> = _text
}