package com.example.tim.foodapp.data.models

import com.google.gson.annotations.SerializedName

class Product(@SerializedName("product_name") var productName: String?, @SerializedName("image_url") var imageUrl: String?)