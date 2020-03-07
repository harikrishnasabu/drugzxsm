package com.pms.drugzx.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pms.drugzx.R
import com.pms.drugzx.databinding.FragmentCustomerDetailsBinding

/**
 * A simple [Fragment] subclass.
 */
class CustomerDetailsFragment : Fragment() {
    private var _binding:FragmentCustomerDetailsBinding?=null
    private val binding get() = _binding!!
            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                _binding =FragmentCustomerDetailsBinding.inflate(inflater, container, false)
                val view = binding.root
                return view
            }

}
