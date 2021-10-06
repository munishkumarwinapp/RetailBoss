package com.winapp.retailboss.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.winapp.retailboss.Adapters.CurrencyAdapter
import com.winapp.retailboss.Adapters.PaymentAdapter
import com.winapp.retailboss.Adapters.SettlementAdapter
import com.winapp.retailboss.R

class SettlementFragment : Fragment() {

    private lateinit var viewOfLayout:View
    lateinit var settlementAdapter: SettlementAdapter
    lateinit var paymentAdapter: PaymentAdapter
    lateinit var currencyAdapter: CurrencyAdapter
    lateinit var settlementRecyclerView: RecyclerView
    lateinit var paymentRecyclerView: RecyclerView
    lateinit var currencyRecyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewOfLayout =  inflater.inflate(R.layout.fragment_settlement, container, false)
        initComponent()
        return viewOfLayout
    }

    private fun initComponent(){
        settlementRecyclerView = viewOfLayout.findViewById(R.id.settlement_recyler_view)
        settlementRecyclerView.layoutManager  = LinearLayoutManager(requireContext())
        settlementRecyclerView.setHasFixedSize(true)


        currencyRecyclerView = viewOfLayout.findViewById(R.id.recyclerView)
        currencyRecyclerView.layoutManager  = LinearLayoutManager(requireContext())
        currencyRecyclerView.setHasFixedSize(true)

        paymentRecyclerView = viewOfLayout.findViewById(R.id.currencyRecyclerView)
        paymentRecyclerView.layoutManager  = LinearLayoutManager(requireContext())
        paymentRecyclerView.setHasFixedSize(true)

        setAdapter()
    }

    private fun setAdapter(){

        settlementAdapter = SettlementAdapter(requireContext())
        settlementRecyclerView.adapter = settlementAdapter

        paymentAdapter= PaymentAdapter(requireContext())
        paymentRecyclerView.adapter = paymentAdapter

        currencyAdapter= CurrencyAdapter(requireContext())
        currencyRecyclerView.adapter = currencyAdapter


    }
}