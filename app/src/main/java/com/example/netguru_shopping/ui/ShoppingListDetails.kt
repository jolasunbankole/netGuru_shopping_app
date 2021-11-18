package com.example.netguru_shopping.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netguru_shopping.R
import com.example.netguru_shopping.adapter.ShoppingDAdapter
import com.example.netguru_shopping.databinding.FragmentShoppingListDetailsBinding
import com.example.netguru_shopping.model.ShoppingListData2
import com.example.netguru_shopping.shareviewmodel.SharedViewModel
import kotlin.random.Random


class ShoppingListDetails : Fragment() {
    private lateinit var _binding: FragmentShoppingListDetailsBinding
    private val binding get() = _binding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val gList = groceryList(100)
    private val adapter = ShoppingDAdapter(gList, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shopping_list_details, container, false)
        sharedViewModel.shoppingDetail.observe(viewLifecycleOwner) {  }
        binding.recyclerView2.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView2.adapter = adapter
        binding.ofloatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.nav_host_fragment)
        }
        binding.insertItem2.setOnClickListener {
            val index: Int = Random.nextInt(8)

            val newItem2 = ShoppingListData2(
                R.drawable.add_shopping,
                "Grocery List $index",
            )
            gList.add(index, newItem2)
            adapter.notifyItemInserted(index)
        }

        binding.removeItem2.setOnClickListener {
            val index: Int = Random.nextInt(8)

            gList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }
        return binding.root


    }

    fun onClick(position: Int) {
        val clickItem: ShoppingListData2 = gList[position]
        clickItem.textView2 = "clicked"
        adapter.notifyItemChanged(position)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ofloatingActionButton.setOnClickListener{
            val action = ShoppingListDetailsDirections.actionShoppingListDetailsToShoppingArchivedFragment()
            findNavController().navigate(action)
        }
    }




    private fun groceryList(size: Int): ArrayList<ShoppingListData2>{
        val list = ArrayList<ShoppingListData2>()

        for (i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.add_shopping
                else -> R.drawable.add_shopping
            }
            val item = ShoppingListData2(drawable, "Grocery List $i")
            list += item
        }
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}

