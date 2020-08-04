package com.example.mvvm2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm2.databinding.PageBinding
import com.example.mvvm2.viewmodel.DataViewModel
import com.example.mvvm2.viewmodel.DataViewModelFactory

class PageFrgmt (var number : Int) : Fragment() {

    lateinit
    var binding     :   PageBinding

    val viewModel   :   DataViewModel by lazy { initViewModel() }
//    val viewModel   :   DataViewModel by viewModels()

    fun initViewModel() : DataViewModel{
//        ViewModelProviders.of(this, DataViewModelFactory).get(DataViewModel::class.java)
        return ViewModelProvider(this).get(DataViewModel::class.java)
    }

    fun initBinding(){
        binding.lifecycleOwner = this
        binding.number = number
        binding.data = viewModel.data
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("MVVM_TAG","page $number onCreateView")
        binding = PageBinding.inflate(inflater,container,false)
        initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MVVM_TAG","page $number onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("MVVM_TAG","page $number onDetach")
    }
}