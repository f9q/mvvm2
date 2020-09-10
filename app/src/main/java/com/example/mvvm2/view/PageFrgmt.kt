package com.example.mvvm2.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.mvvm2.databinding.PageBinding
import com.example.mvvm2.viewmodel.DataViewModel
import com.example.mvvm2.viewmodel.DataViewModelFactory


class PageFrgmt (var number : Int) : Fragment() {

    companion object {  @JvmStatic var  VMSOwner  =   false }

    lateinit
    var binding     :   PageBinding

    val viewModel1  :   DataViewModel by lazy { initViewModel() }
    val viewModel2  :   DataViewModel by activityViewModels(this::factory)
    val viewModel3  :   DataViewModel by viewModels(this::ownerProducer,this::factory)


    fun factory() : DataViewModelFactory{
        return DataViewModelFactory(Bundle())
    }
    fun ownerProducer() : ViewModelStoreOwner {
        return this
    }

    fun initViewModel() : DataViewModel{
        return if (VMSOwner){
//            ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
            ViewModelProvider(requireActivity(), DataViewModelFactory(Bundle())).get(DataViewModel::class.java)
        }else{
//            ViewModelProvider(this).get(DataViewModel::class.java)
            ViewModelProvider(this,DataViewModelFactory(Bundle())).get(DataViewModel::class.java)
        }
    }

    fun initBinding(){
        binding.lifecycleOwner = this
        binding.number = number
//        val viewModel2  :   DataViewModel by activityViewModels(this::factory)
//        val viewModel3  :   DataViewModel by viewModels(this::ownerProducer,this::factory)
        binding.data = if (VMSOwner) viewModel2.loadData() else viewModel3.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("MVVM_TAG","PageFrgmt page $number onCreateView ,VMSOwner = $VMSOwner")
        binding = PageBinding.inflate(inflater,container,false)
        initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("MVVM_TAG","PageFrgmt page $number onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("MVVM_TAG","PageFrgmt page $number onActivityCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("MVVM_TAG","PageFrgmt page $number onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MVVM_TAG","PageFrgmt page $number onDestroy")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("MVVM_TAG","PageFrgmt page $number onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("MVVM_TAG","PageFrgmt page $number onDetach")
    }
}