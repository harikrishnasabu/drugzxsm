package com.pms.drugzx.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.pms.drugzx.R
import com.pms.drugzx.adapters.SelectedProductsRecyclerAdapter
import com.pms.drugzx.databinding.FragmentSelectedProductsBinding
import com.pms.drugzx.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_selected_products.*

/**
 * A simple [Fragment] subclass.
 */
class SelectedProductsFragment : Fragment() ,View.OnClickListener {
    private var _binding: FragmentSelectedProductsBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProductListingVM
    lateinit var navController: NavController
    private lateinit var recyclerAdapter: SelectedProductsRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSelectedProductsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductListingVM::class.java)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        println("SelectedProducts"+viewModel.getProducts().toString())
        recyclerAdapter.setProductList(viewModel.getProducts())
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_order).setOnClickListener(this)

    }

    private fun initRecyclerView() {
        rv_selected_products.apply {
            layoutManager= LinearLayoutManager(this.context)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            recyclerAdapter= SelectedProductsRecyclerAdapter(viewModel)
            adapter=recyclerAdapter
        }
    }

    override fun onClick(v: View?) {


        navController!!.navigate(
            R.id.orderSummaryFragment
        )


    }

}



