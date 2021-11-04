package com.example.netguru_shopping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netguru_shopping.R
import com.example.netguru_shopping.model.ShoppingListData

class ShoppingAdapter(
    private val dataset: List<ShoppingListData>, private val listener: OnClickListener
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingListViewHolder>(){

    inner class ShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val textView: TextView = itemView.findViewById(R.id.shopText)
        val imageView: ImageView = itemView.findViewById(R.id.shoppingcart)
        var buttonView: Button = itemView.findViewById(R.id.floatingActionButton)


        init {
            itemView.setOnClickListener(this)

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
        return ShoppingListViewHolder(itemView)

    }




    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView.text = item.textView
        holder.buttonView.setOnClickListener {

        }


    }

    override fun getItemCount() = dataset.size





}