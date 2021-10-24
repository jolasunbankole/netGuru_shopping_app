package com.example.netguru_shopping

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netguru_shopping.adapter.ShoppingAdapter
import com.example.netguru_shopping.model.ShoppingListData
import com.example.netguru_shopping.model.ShoppingListData2
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ShoppingAdapter.OnClickListener {
    private val sList = shoppingList(100)
    private val gList = groceryList(100)
    private val adapter = ShoppingAdapter(sList,gList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_shopping_list)




        //Initialize data.

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view1)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)



    }

    fun insertItem(View: View){
        val index: Int = Random.nextInt(8)

        val newItem = ShoppingListData(
            R.drawable.shopping_cart,
        "New Item at position $index",
        )
        sList.add(index, newItem)
        adapter.notifyItemInserted(index)
    }

    fun insertItem2(View: View){
        val index: Int = Random.nextInt(8)

        val newItem2 = ShoppingListData2(
            R.drawable.add_shopping,
            "New Item at position $index",
        )
        gList.add(index, newItem2)
        adapter.notifyItemInserted(index)
    }

    fun removeItem(View: View){
        val index: Int = Random.nextInt(8)

        sList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    fun removeItem2(View: View){
        val index: Int = Random.nextInt(8)

        gList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    private fun shoppingList(size: Int): ArrayList<ShoppingListData>{
        val list = ArrayList<ShoppingListData>()

        for (i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.shopping_cart
                else -> R.drawable.shopping_cart
            }
            val item = ShoppingListData(drawable, "Shopping $i")
            list += item
        }
        return list
    }

    private fun groceryList(size: Int): ArrayList<ShoppingListData2>{
        val list = ArrayList<ShoppingListData2>()

        for (i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.add_shopping
                else -> R.drawable.add_shopping
            }
            val item = ShoppingListData2(drawable, "Shopping $i")
            list += item
        }
        return list
    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: ShoppingListData = sList[position]
        val clickItem: ShoppingListData2 = gList[position]
        clickedItem.textView = "clicked"
        clickItem.textView2 = "clicked"
        adapter.notifyItemChanged(position)


    }




}