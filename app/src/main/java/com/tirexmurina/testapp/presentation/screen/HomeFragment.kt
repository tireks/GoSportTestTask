package com.tirexmurina.testapp.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tirexmurina.testapp.BaseFragment
import com.tirexmurina.testapp.R
import com.tirexmurina.testapp.databinding.FragmentHomeBinding
import com.tirexmurina.testapp.presentation.MainListAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViews()
    }

    private fun setRecyclerViews() {
        /*val mainLayoutManager = LinearLayoutManager(context)*/
        binding.testRecycler.adapter = MainListAdapter()
        binding.testRecycler.layoutManager = LinearLayoutManager(context)


        //todo тут временно популейтим
        val list = (1..50).toList()
        (binding.testRecycler.adapter as? MainListAdapter)?.contents = list
    }


}