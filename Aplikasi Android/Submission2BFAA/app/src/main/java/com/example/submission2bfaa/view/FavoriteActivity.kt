package com.example.submission2bfaa.view

import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2bfaa.Helper.FavoriteHelper
import com.example.submission2bfaa.Helper.MappingHelper
import com.example.submission2bfaa.R
import com.example.submission2bfaa.adapter.FavoriteAdapter
import com.example.submission2bfaa.db.DatabaseContract.UserFavoriteColumns.Companion.CONTENT_URI
import com.example.submission2bfaa.model.Favorite
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {

    private lateinit var adapter: FavoriteAdapter
    private lateinit var dbHelper: FavoriteHelper

    companion object {
        private const val EXTRA_DATA = "EXTRA_DATA"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        dbHelper = FavoriteHelper.getInstance(applicationContext)
        dbHelper.open()

        etRecyclerViewFavorite.layoutManager = LinearLayoutManager(this)
        etRecyclerViewFavorite.setHasFixedSize(true)
        adapter = FavoriteAdapter(this)
        etRecyclerViewFavorite.adapter = adapter

        val handleThread = HandlerThread("DataObserver")
        handleThread.start()
        val handler = Handler(handleThread.looper)
        val myObserver = object : ContentObserver(handler) {
            override fun onChange(selfChange: Boolean) {
                loadListFavourite()
            }
        }
        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)

        if (savedInstanceState == null) {
            loadListFavourite()
        } else {
            val list = savedInstanceState.getParcelableArrayList<Favorite>(EXTRA_DATA)
            if (list != null) {
                adapter.favoriteList = list
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_DATA, adapter.favoriteList)
    }

    private fun loadListFavourite() {
        GlobalScope.launch(Dispatchers.Main) {
            progressBarFavorite.visibility = View.VISIBLE
            val deferredFav = async(Dispatchers.IO) {
                val cursor = contentResolver.query(CONTENT_URI,
                    null,
                    null,
                    null,
                    null
                )
                MappingHelper.mapCursorToArrayList(cursor)
            }
            val favData = deferredFav.await()
            progressBarFavorite.visibility = View.INVISIBLE
            if (favData.size > 0) {
                adapter.favoriteList = favData
            } else {
                adapter.favoriteList = ArrayList()

            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadListFavourite()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}