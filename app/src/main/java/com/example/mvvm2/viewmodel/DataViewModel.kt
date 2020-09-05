package com.example.mvvm2.viewmodel

import android.content.Context
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.DataModel

class DataViewModel(var context: Context): ViewModel(),Observable {

    val model = DataModel()

    fun loadData() = model.loadData()
    fun loadLiveData() = model.loadLiveData()

    override fun onCleared() {
        super.onCleared()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}