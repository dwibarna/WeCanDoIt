package com.example.submission2bfaa.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import com.example.submission2bfaa.model.Followers
import org.json.JSONArray
import org.json.JSONObject
import com.example.submission2bfaa.view.MainActivity

class FollowersViewModel:ViewModel() {
    private val listFollowersNonMutable = ArrayList<Followers>()
    private val listFollowers  = MutableLiveData<ArrayList<Followers>>()

    fun getListFollower(): LiveData<ArrayList<Followers>> {
        return listFollowers
    }

    fun getDetailModel(userDetail:String,context: Context){
        val client = AsyncHttpClient()
        val url ="https://api.github.com/users/$userDetail"
        val token = "token 65d954dc1ba31e07beaf2bab17ec97a7cb96ff90"
        client.addHeader("Authorization",token)
        client.addHeader("User-Agent","request")
        client.get(url,object:AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                Log.d(MainActivity.TAG ,result)
                try {
                    val jsonObject = JSONObject(result)
                    val followers = Followers()
                    followers.username = jsonObject.getString("login")
                    followers.avatar = jsonObject.getString("avatar_url")
                    followers.followers = jsonObject.getString("followers")
                    followers.dataFollowing = jsonObject.getString("following")
                    listFollowersNonMutable.add(followers)
                    listFollowers.postValue(listFollowersNonMutable)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
            override fun onFailure(
                statusCode: Int,
                headers: Array< Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun dataFollowers(person: String,context: Context){
        val client = AsyncHttpClient()
        val url = "https://api.github.com/users/$person/followers"
        val token = "token 65d954dc1ba31e07beaf2bab17ec97a7cb96ff90"
        client.addHeader("Authorization", token)
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                try {
                    val jsonArray = JSONArray(result)
                    for (i in 0 until jsonArray.length()){
                        val items = jsonArray.getJSONObject(i)
                        val username = items.getString("login")
                        getDetailModel(username,context)
                    }

                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}