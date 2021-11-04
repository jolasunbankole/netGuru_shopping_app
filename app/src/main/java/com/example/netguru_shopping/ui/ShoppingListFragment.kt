package com.example.netguru_shopping.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.netguru_shopping.R
import com.example.netguru_shopping.databinding.FragmentShoppingListBinding
import com.example.netguru_shopping.shareviewmodel.SharedViewModel


class ShoppingListFragment : Fragment() {
    private var _binding: FragmentShoppingListBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shopping_list, container, false)
        sharedViewModel.shoppingList.observe(viewLifecycleOwner) {binding.recyclerView1 }
        //floatingActionButton
        binding.floatingActionButton

        return binding.root

    }




    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }






}