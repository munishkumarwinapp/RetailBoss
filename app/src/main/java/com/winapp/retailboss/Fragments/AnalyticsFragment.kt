package com.winapp.retailboss.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.Adapters.AnalyticsAdapter
import com.winapp.retailboss.R

class AnalyticsFragment : Fragment() {

    private lateinit var viewOfLayout:View
    private lateinit var analyticsRecyclerView: RecyclerView
    lateinit var analyticsAdapter: AnalyticsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewOfLayout =  inflater.inflate(R.layout.fragment_analytics, container, false)
        initComponent()
        return viewOfLayout
    }

    private fun initComponent() {

        analyticsRecyclerView = viewOfLayout.findViewById(R.id.analytics_recycler_view)
        analyticsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        analyticsRecyclerView.setHasFixedSize(true)
        setAdapter()

    }

    private fun setAdapter() {
        analyticsAdapter = AnalyticsAdapter(requireContext())
        analyticsRecyclerView.adapter = analyticsAdapter


    }


}