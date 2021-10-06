package com.winapp.retailboss.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.winapp.retailboss.R

class LoginFragment : Fragment() {

    lateinit var viewOfLayout:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewOfLayout =  inflater.inflate(R.layout.fragment_login, container, false)
       return viewOfLayout
     }
}