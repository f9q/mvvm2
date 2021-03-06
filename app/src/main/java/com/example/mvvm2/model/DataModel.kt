package com.example.mvvm2.model

import android.os.Bundle
import androidx.lifecycle.MutableLiveData


class DataModel(var args : Bundle) {

    val liveData    :   MutableLiveData<Data>   by  lazy { initLiveData() }
    val data        :   Data                    by  lazy { initData() }

    fun initLiveData() : MutableLiveData<Data>{
        val data = Data().apply {
            name = "liveData"
        }
        return MutableLiveData(data)
    }

    fun initData() : Data{
        return Data().apply {
            name = "Data"
        }
    }

    fun loadData() : Data{
        return data
    }

    fun loadLiveData() : MutableLiveData<Data>{
        return liveData
    }
}