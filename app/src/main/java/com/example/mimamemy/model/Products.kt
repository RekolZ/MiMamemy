package com.example.mimamemy.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("id"                 ) var id                 : Int?    = null,
    @SerializedName("title"              ) var title              : String? = null,
    @SerializedName("description"        ) var description        : String? = null,
    @SerializedName("price"              ) var price              : Int?    = null,
    @SerializedName("dicsountPercentage" ) var dicsountPercentage : Double? = null,
    @SerializedName("rating"             ) var rating             : Double? = null,
    @SerializedName("stock"              ) var stock              : Int?    = null,
    @SerializedName("brand"              ) var brand              : String? = null,
    @SerializedName("category"           ) var category           : String? = null,
    @SerializedName("thumbnail"          ) var thumbnail          : String? = null,
    @SerializedName("images"             ) var images             : ArrayList<String>? = arrayListOf()
)
