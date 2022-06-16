package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

interface ChatListClickListener {
    fun onChatListItemClick(view: View, product: Product)
}

class ProductAdapter(
    options: FirebaseRecyclerOptions<Product>,
    val chatListClickListener: ChatListClickListener
) :
    FirebaseRecyclerAdapter<Product, ProductAdapter.MyViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Product) {
        val name = holder.itemView.findViewById<TextView>(R.id.txtName)
        val price = holder.itemView.findViewById<TextView>(R.id.txtPrice)
        val desc = holder.itemView.findViewById<TextView>(R.id.txtDesc)

        name.text = model.name
        price.text = model.price
        desc.text = model.description

        holder.itemView.setOnClickListener {
            chatListClickListener.onChatListItemClick(holder.itemView, model)
        }
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout, parent, false)) {
    }
}