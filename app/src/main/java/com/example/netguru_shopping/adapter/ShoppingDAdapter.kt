package com.example.netguru_shopping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netguru_shopping.R
import com.example.netguru_shopping.model.ShoppingListData2
import com.example.netguru_shopping.ui.ShoppingListDetails

class ShoppingDAdapter(
    private val newSet: List<ShoppingListData2>,
    private val listen: ShoppingListDetails,
): RecyclerView.Adapter<ShoppingDAdapter.ShoppingDetailViewHolder>(){
   inner class ShoppingDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        val textDets: TextView = itemView.findViewById(R.id.groList)
        val imageDets: ImageView = itemView.findViewById(R.id.Addingcart)



        init {
            itemView.setOnClickListener(this)


        }



        override fun onClick(view: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            listen.onClick(position)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingDAdapter.ShoppingDetailViewHolder {
            val d = LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
            return ShoppingDetailViewHolder(d)
    }

    override fun onBindViewHolder(holder: ShoppingDAdapter.ShoppingDetailViewHolder, position: Int) {
        val detail = newSet[position]
        holder.imageDets.setImageResource(detail.imageResourceId2)
        holder.textDets.text = detail.textView2
    }

    override fun getItemCount() = newSet.size


}


