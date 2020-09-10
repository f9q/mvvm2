package com.example.mvvm2.viewmodel

import android.os.Bundle
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.DataModel

class DataViewModel(var args : Bundle): ViewModel(),Observable {

    val model = DataModel(args)

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