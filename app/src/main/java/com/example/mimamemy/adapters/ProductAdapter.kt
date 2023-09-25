package com.example.mimamemy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mimamemy.R
import com.example.mimamemy.model.Products
import com.squareup.picasso.Picasso

class ProductAdapter(private val
        mlist:List<Products>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = ItemView.findViewById(R.id.ImageView)
        val textView: TextView = ItemView.findViewById(R.id.textView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mlist.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product=mlist[position]
        holder.textView.setText(product.title)
        Picasso.get().load(product.images?.get(0)).into(holder.imageView)
    }
}
