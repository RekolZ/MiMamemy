package com.example.mimamemy.activites
import com.example.mimamemy.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimamemy.adapters.ProductAdapter
import com.example.mimamemy.datasource.ServiceBuilder
import com.example.mimamemy.model.ApiResponse
import com.example.mimamemy.model.Products
import com.example.mimamemy.interfaces.ProductsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var data= ArrayList<Products>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getAllProducts()
    }
    private fun getAllProducts() {
        val retrofit = ServiceBuilder.buildService(ProductsInterface::class.java)
        retrofit.getAllProducts().enqueue(object: Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response:
            Response<ApiResponse>) {
                try {
                    //чтобы избежать NullPointerException ставим !!
                    val responceBody=response.body()!!
                    data=responceBody.products
                    var adapter= ProductAdapter(data)
                    binding.recyclerView.adapter=adapter
                }
                catch (ex:java.lang.Exception ){
                    ex.printStackTrace()
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("Failed","Api Failad"+t.message)
            }

        }
        )
    }
}