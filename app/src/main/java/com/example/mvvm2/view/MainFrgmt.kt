package com.example.mvvm2.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm2.databinding.FrgmtMainBinding
import com.example.mvvm2.viewmodel.DataViewModel
import com.example.mvvm2.viewmodel.DataViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFrgmt : Fragment(){
    lateinit var binding : FrgmtMainBinding

    val viewModel   :   DataViewModel by lazy {initViewModel()}
    val viewModel2  :   DataViewModel by activityViewModels(this::factory)
    val viewModel3  :   DataViewModel by viewModels(this::ownerProducer,this::factory)


    fun factory() : DataViewModelFactory{
        return DataViewModelFactory(Bundle())
    }
    fun ownerProducer() : ViewModelStoreOwner {
        return this
    }
    fun initViewModel() : DataViewModel{
//        return ViewModelProvider(this).get(DataViewModel::class.java)
        return ViewModelProvider(requireActivity(),DataViewModelFactory(Bundle())).get(DataViewModel::class.java)
    }


    val checkedListener  =  object  : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            PageFrgmt.VMSOwner = p1
            binding.vmsOwner = p1
//            Data.value = 100
//            binding.invalidateAll()
        }
    }

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
        binding.storeOwnerSwitch.setOnCheckedChangeListener(checkedListener)
        binding.vmsOwner = PageFrgmt.VMSOwner
        binding.data = viewModel2.loadData()
        binding.liveData = viewModel.loadLiveData()
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

    class PageAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter( fragmentManager,lifecycle) {
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