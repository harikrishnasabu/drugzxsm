package com.pms.drugzsm.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.pms.drugzsm.R
import com.pms.drugzsm.databinding.FragmentManageBinding


/**
 * A simple [Fragment] subclass.
 */
class ManageFragment : Fragment(),View.OnClickListener {
    private var _binding:FragmentManageBinding?=null
    private val binding get() = _binding!!
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentManageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        _binding?.cvAddProduct?.setOnClickListener(this)
        _binding?.cvAddSupplier?.setOnClickListener(this)
        _binding?.cvUpdateProduct?.setOnClickListener(this)
        _binding?.cvUpdateSupplier?.setOnClickListener(this)
        _binding?.cvDeleteProduct?.setOnClickListener(this)
        _binding?.cvDelSupplier?.setOnClickListener(this)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.cv_add_product ->
                navController!!.navigate(
                    R.id.addProductFragment)
            R.id.cv_add_supplier -> navController!!.navigate(
                R.id.addSupplierFragment)
            R.id.cv_update_product -> navController!!.navigate(
                R.id.updateProductFragment)
                R.id.cv_update_supplier -> navController!!.navigate(
                    R.id.updateSupplierFragment)
            R.id.cv_delete_product -> navController!!.navigate(
                R.id.deleteProductFragment)
            R.id.cv_del_supplier -> navController!!.navigate(
                R.id.deleteSupplierFragment)
            // R.id.cancel_btn -> activity!!.onBackPressed()
        }   }

}
