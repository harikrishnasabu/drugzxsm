package com.pms.drugzsm.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pms.drugzsm.databinding.FragmentUpdateSupplierBinding


/**
 * A simple [Fragment] subclass.
 */
class UpdateSupplierFragment : Fragment() {
    private var _binding:FragmentUpdateSupplierBinding?=null
    private val binding get() = _binding!!
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateSupplierBinding.inflate(inflater, container, false)
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
