package com.example.hilt_example

import android.util.Log
import javax.inject.Inject

class LoggerService @Inject constructor(){

    fun log(message: String) {
        Log.d(TAG, message)
    }
}