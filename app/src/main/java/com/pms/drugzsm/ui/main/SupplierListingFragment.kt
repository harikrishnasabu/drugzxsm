

package com.pms.drugzsm.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.pms.drugzsm.R
import com.pms.drugzsm.adapters.ProductsRecyclerAdapter
import com.pms.drugzsm.adapters.SupplierRecyclerAdapter
import com.pms.drugzsm.databinding.FragmentSupplierListingBinding
import com.pms.drugzsm.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_product_listing.*
import kotlinx.android.synthetic.main.fragment_supplier_listing.*


/**
 * A simple [Fragment] subclass.
 */
class SupplierListingFragment : Fragment() {
    private var _binding:FragmentSupplierListingBinding? = null
    private lateinit var viewModel: SupplierListingVM
    private lateinit var recyclerAdapter: SupplierRecyclerAdapter
    lateinit var navController: NavController
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSupplierListingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SupplierListingVM::class.java)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSuppliersList().observe(viewLifecycleOwner, Observer {
            initRecyclerView()
            println("API"+it.toString())
            recyclerAdapter.setProductList(it as ArrayList)

        })
        viewModel._supplier.observe(viewLifecycleOwner, Observer {
            navController!!.navigate(
                R.id.productListingFragment
            )
        })
        //println("HARDCODED"+viewModel.getProducts().toString())

        navController = Navigation.findNavController(view)



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
    private fun initRecyclerView() {
        rv_suppliers.apply {
            layoutManager= LinearLayoutManager(this.context)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            recyclerAdapter= SupplierRecyclerAdapter(viewModel)
            adapter=recyclerAdapter
        }
    }



}

