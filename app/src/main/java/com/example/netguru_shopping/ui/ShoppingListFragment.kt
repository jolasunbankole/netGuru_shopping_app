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
import com.example.netguru_shopping.adapter.ShoppingAdapter
import com.example.netguru_shopping.databinding.FragmentShoppingListBinding
import com.example.netguru_shopping.model.ShoppingListData
import com.example.netguru_shopping.shareviewmodel.SharedViewModel
import kotlin.random.Random


class ShoppingListFragment : Fragment() , ShoppingAdapter.OnClickListener{
    private lateinit var _binding: FragmentShoppingListBinding
    private val binding get() = _binding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val sList = shoppingList(100)
    private val adapter = ShoppingAdapter(sList, this)



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shopping_list, container, false)
        sharedViewModel.shoppingList.observe(viewLifecycleOwner) { binding.viewModel }
        binding.recyclerView1.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView1.adapter = adapter
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.nav_host_fragment)
        }
        // allows me to add content in my app
        binding.addItem.setOnClickListener {
            val index: Int = Random.nextInt(8)

            val newItem = ShoppingListData(
                R.drawable.shopping_cart,
                "Shopping List  $index",
            )
            sList.add(index, newItem)
            adapter.notifyItemInserted(index)
        }
        // allows me to remove content in my app
        binding.removeItem.setOnClickListener {
            val index: Int = Random.nextInt(8)

            sList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }
        //Initialize data.
        return binding.root

    }



    override fun onClick(position: Int) {
        val clickedItem: ShoppingListData = sList[position]
        clickedItem.textView = "clicked"
        adapter.notifyItemChanged(position)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener{
            val action = ShoppingListFragmentDirections.actionShoppingListFragmentToShoppingListDetails()
            findNavController().navigate(action)
        }
    }





    // this allows my shopping list to have a long list with text
    private fun shoppingList(size: Int): ArrayList<ShoppingListData>{
        val list = ArrayList<ShoppingListData>()

        for (i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.shopping_cart
                else -> R.drawable.shopping_cart
            }
            val item = ShoppingListData(drawable, "Shopping List $i")
            list += item
        }
        return list
    }












}