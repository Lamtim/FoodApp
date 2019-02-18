package com.example.tim.foodapp.data.models

import com.google.gson.annotations.SerializedName

class State(@SerializedName("status_verbose") var status: String?, var code: String?, var product: Product?)