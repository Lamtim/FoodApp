package com.example.tim.foodapp.data.models

import com.google.gson.annotations.SerializedName

class State(@SerializedName("status_verbose") var statusVerbose: String?, var status: Int?, var code: String?, var product: Product?)