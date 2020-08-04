package com.example.mvvm2.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.Data

class DataViewModel : ViewModel(),Observable {

    val data = Data()

    override fun onCleared() {
        super.onCleared()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}