package com.example.mvvm2.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm2.databinding.FrgmtMainBinding
import com.example.mvvm2.model.Data
import com.example.mvvm2.viewmodel.DataViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFrgmt : Fragment(){

    lateinit var binding : FrgmtMainBinding
    val data        : Data  by lazy {
        Log.e("MainFrgmt","lazy init ")
        val data = Data()
        data.name = "data"
        data
    }
    var liveData    = MutableLiveData<Data>()

    fun initPages(){
        val adapter = PageAdapter(childFragmentManager,lifecycle)

        for (i in  0..15){
            val page = PageFrgmt(i)
            adapter.addPage(page)
        }
        binding.pages.adapter = adapter
        binding.pages.offscreenPageLimit = 1

        createTabs(binding.tabs,binding.pages)
    }

    fun initBinding() {
        Log.e("MainFrgmt","initBinding ")
        binding.data = data

        val data2 = Data()
        data2.name = "live data"

        liveData.value = data2
        binding.liveData = liveData
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MainFrgmt","onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("MainFrgmt","onAttach")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("MainFrgmt","onCreateView")
        binding = FrgmtMainBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        initBinding()
        initPages()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("MainFrgmt","onDetach")
    }

    fun createTabs(tabs : TabLayout, pager: ViewPager2){
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = "page$position"
        }.attach()
    }

    inner class PageAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter( fragmentManager,lifecycle) {
        var pages = ArrayList<Fragment>()
        fun addPage(page : Fragment){
            pages.add(page)
        }

        override fun getItemCount(): Int {
            return pages.size
        }

        override fun createFragment(position: Int): Fragment {
            return pages.get(position)
        }
    }
}