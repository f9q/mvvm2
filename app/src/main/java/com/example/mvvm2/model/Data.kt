package com.example.mvvm2.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mvvm2.BR


class Data : BaseObservable(){

    var desc    =   ObservableField<String>()
    var room    =   MutableLiveData<String>("主209")

    init{
        ++value
    }

    @get:Bindable
    var name    =   "unknown_"
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    companion object : BaseObservable(){
        @get:Bindable
        @JvmStatic var value   =   0
            set(value) {
                field = value
                notifyPropertyChanged(BR.name)
            }
    }
}