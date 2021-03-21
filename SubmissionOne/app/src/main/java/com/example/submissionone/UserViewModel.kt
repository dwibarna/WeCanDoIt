package com.example.submissionone

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val listUser = MutableLiveData<ArrayList<User>>()
    private val listUserNonMutable = ArrayList<User>()

    fun getListUser():LiveData<ArrayList<User>>{
        return listUser
    }

    fun getDataModel(context: Context){

    }


}