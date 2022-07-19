package com.example.hilt_example

import android.util.Log
import javax.inject.Inject

const val TAG = "UserRepository"

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SQLRepository @Inject constructor(): UserRepository{
    override fun saveUser(email: String, password: String){
        Log.d(TAG,"$email with password $password saved to Db")
    }
}

class FirebaseRepository : UserRepository{
    override fun saveUser(email: String, password: String){
        Log.d(TAG,"$email with password $password saved to Firebase")
    }
}