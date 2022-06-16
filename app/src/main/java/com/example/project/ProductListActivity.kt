package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class ProductListActivity : AppCompatActivity(), ChatListClickListener {
    private var adapter: ProductAdapter? = null
    private lateinit var listener: ChatListClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val query = FirebaseDatabase.getInstance().reference.child("burgers")
        val options =
            FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product::class.java)
                .build()
        listener = this
        adapter = ProductAdapter(options, listener)
        val rView = findViewById<RecyclerView>(R.id.productRecycleView)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onChatListItemClick(view: View, product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("name", product.name)
        intent.putExtra("description", product.description)
        intent.putExtra("price", product.price)
        startActivity(intent)
    }
}