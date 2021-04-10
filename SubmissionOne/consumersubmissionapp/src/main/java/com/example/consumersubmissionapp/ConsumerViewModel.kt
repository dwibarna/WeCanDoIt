package com.example.consumersubmissionapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConsumerViewModel:ViewModel() {


    private var mutableConsumerList = MutableLiveData<ArrayList<FavoriteUser>>()


    fun getConsumerList():LiveData<ArrayList<FavoriteUser>>{
        return mutableConsumerList
    }

    fun getConsumer(context: Context){
        val cursor = context.contentResolver.query(
            DatabaseContract.ConsumerFavoriteColumns.CONTENT_URI,
            null,
            null,
            null,
            null,
            null
        )
        val listReceive = MappingHelper.mapCursor(cursor)
        mutableConsumerList.postValue(listReceive)
    }
}
