package com.example.consumersubmissionapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConsumerViewModel : ViewModel() {

    private var mutableConsumerList = MutableLiveData<ArrayList<FavoriteUser>>()

    fun getConsumerList(): LiveData<ArrayList<FavoriteUser>> {
        return mutableConsumerList
    }

    fun getConsumer(context: Context) {
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
