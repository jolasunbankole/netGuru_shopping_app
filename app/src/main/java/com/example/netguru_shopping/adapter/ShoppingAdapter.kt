package com.example.netguru_shopping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netguru_shopping.R
import com.example.netguru_shopping.model.ShoppingListData
import com.example.netguru_shopping.model.ShoppingListData2

class ShoppingAdapter(
    private val dataset: List<ShoppingListData>,
    private val dataset2: List<ShoppingListData2>,
    private val listener: OnClickListener


    ) : RecyclerView.Adapter<ShoppingAdapter.ShoppingListViewHolder>(){



    inner class ShoppingListViewHolder(itemView: View, itemView2: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        val textView: TextView = itemView.findViewById(R.id.item_title)
        val textView2: TextView = itemView2.findViewById(R.id.item_title2)
        val imageView: ImageView = itemView.findViewById(R.id.shoppingcart)
        val imageView2: ImageView = itemView2.findViewById(R.id.Addingcart)

        init {
            itemView.setOnClickListener(this)
            itemView2.setOnClickListener(this)

        }


        override fun onClick(view: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            listener.onClick(position)


        }

    }

    interface OnClickListener{
        fun onClick(position: Int)


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingAdapter.ShoppingListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val itemView2 = LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return ShoppingListViewHolder(itemView, itemView2)


    }




    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val item = dataset[position]
        val item2 = dataset2[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.imageView2.setImageResource(item2.imageResourceId2)
        holder.textView.text = item.textView
        holder.textView2.text = item2.textView2


    }

    override fun getItemCount() = dataset.size





}