package com.example.submissionone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {

    private val listUser = MutableLiveData<ArrayList<User>>()


    fun getListUser():LiveData<ArrayList<User>>{
        return listUser
    }


}