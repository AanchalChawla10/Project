package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val name: String = intent.getStringExtra("name").toString()
        val description: String = intent.getStringExtra("description").toString()
        val price: String = intent.getStringExtra("price").toString()

        val txtNameProductDetail = findViewById<TextView>(R.id.txtNameProductDetail)
        val txtDescriptionProductDetail = findViewById<TextView>(R.id.txtDescriptionProductDetail)
        val btnBuyNow = findViewById<Button>(R.id.btnBuyNow)

        txtNameProductDetail.text = name
        txtDescriptionProductDetail.text = description
        btnBuyNow.text = String.format("Buy now: %s", price)
    }
}