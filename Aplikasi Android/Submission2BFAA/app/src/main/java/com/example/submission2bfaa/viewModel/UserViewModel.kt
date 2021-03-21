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
import com.example.submission2bfaa.model.User
import org.json.JSONArray
import org.json.JSONObject
import com.example.submission2bfaa.view.MainActivity

class UserViewModel: ViewModel(){
    private val listUser = MutableLiveData<ArrayList<User>>()
    private val listUserNonMutable = ArrayList<User>()

    fun getListUser():LiveData<ArrayList<User>> {
        return listUser
    }

    fun getSearchModel(query:String,context: Context){
        val client = AsyncHttpClient()
        val token = "token 65d954dc1ba31e07beaf2bab17ec97a7cb96ff90"
        client.addHeader("Authorization",token)
        client.addHeader("User-Agent","request")
        val url = "https://api.github.com/search/users?q=$query"
        client.get(url,object:AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                Log.d(MainActivity.TAG ,result)
                try {
                    listUserNonMutable.clear()
                    val jsonObject = JSONObject(result)
                    val jsonArray = jsonObject.getJSONArray("items")
                    for(i in 0 until jsonArray.length()){
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

    fun getDataModel(context: Context){
        val client = AsyncHttpClient()
        val url = "https://api.github.com/users"
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
                Log.d(MainActivity.TAG,result)
                try {
                    val jsonArray = JSONArray(result)
                    for (i in 0 until jsonArray.length()){
                        val items = jsonArray.getJSONObject(i)
                        val username = items.getString("login")
                        getDetailModel(username, context)
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
                Log.d("onFailure", error.message.toString())
            }
        })
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
                    val user = User()
                    user.username = jsonObject.getString("login")
                    user.avatar = jsonObject.getString("avatar_url")
                    user.company = jsonObject.getString("company")
                    user.location = jsonObject.getString("location")
                    user.repository = jsonObject.getString("public_repos")
                    user.following = jsonObject.getString("following")
                    user.followers = jsonObject.getString("followers")
                    listUserNonMutable.add(user)
                    listUser.postValue(listUserNonMutable)
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
}