package com.pms.drugzsm.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pms.drugzsm.R
import com.pms.drugzsm.databinding.FragmentAddSupplierBinding

/**
 * A simple [Fragment] subclass.
 */
class AddSupplierFragment : Fragment() {

    private var _binding:FragmentAddSupplierBinding?=null
    private val binding get() = _binding!!
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddSupplierBinding.inflate(inflater, container, false)
        val view = binding.root
        return view }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}
