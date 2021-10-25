package com.example.netguru_shopping.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.netguru_shopping.R
import com.example.netguru_shopping.databinding.FragmentShoppingArchivedBinding
import com.example.netguru_shopping.shareviewmodel.SharedViewModel


class ShoppingArchivedFragment : Fragment() {

    private var _binding: FragmentShoppingArchivedBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shopping_archived, container, false)
        sharedViewModel.shoppingList.observe(viewLifecycleOwner) {
            binding.recyclerView2
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}