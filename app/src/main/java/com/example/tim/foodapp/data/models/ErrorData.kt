package com.example.tim.foodapp.data.models

class ErrorData(message: String = "", var errorCode: String = "", throwable: Throwable? = null) {
    var message: String = message
    var throwable: Throwable? = throwable
}