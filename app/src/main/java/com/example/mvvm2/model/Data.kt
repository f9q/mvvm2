package com.example.mvvm2.model

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm2.BR


class Data : BaseObservable(){

    var value   =   ObservableInt()
    var desc    =   ObservableField<String>()
    var room    =   MutableLiveData<String>("主209")

    init {
        Log.e("MVVM_TAG","Data constructor count = $count")
        ++count
    }

    @get:Bindable
    var name    =   "unknown_$count"
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    companion object{
        @JvmStatic
        var count   =   0
    }
}