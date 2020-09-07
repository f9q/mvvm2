package com.example.mvvm2.model

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.mvvm2.BR


class Data : BaseObservable {

    var desc    =   ObservableField<String>()
    var room    =   MutableLiveData<String>("主209")

    constructor():super(){
        Log.e("MVVM_Data","constructor(), value = $value")
    }
    init{
        Log.e("MVVM_Data","init, value = $value")
        ++value
        name = "data$value"
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
                notifyPropertyChanged(BR.value)
            }
    }
}