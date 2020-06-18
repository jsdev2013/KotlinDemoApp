package com.jisu.kotlindemoapp.class04

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.adapter.CatAdapter
import com.jisu.kotlindemoapp.class04.database.CatRoomDatabase
import com.jisu.kotlindemoapp.class04.entity.Cat
import kotlinx.android.synthetic.main.activity_class04_db_room_recycler_view.*

class Class04DbRoomRecyclerViewActivity : AppCompatActivity() {

    private var catRoomDatabase : CatRoomDatabase? = null
    private var catList = listOf<Cat>()
    lateinit var mAdapter : CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_room_recycler_view)

        catRoomDatabase = CatRoomDatabase.getInstance(this)

        val r = Runnable {
            try {
                catList = catRoomDatabase?.catDao()?.selectAll()!!
                mAdapter = CatAdapter(this, catList) {
                        cat ->
                    Toast.makeText(this, "Id: ${cat.id}, Name: ${cat.catName}, LifeSpan: ${cat.lifeSpan}, Origin: ${cat.origin},", Toast.LENGTH_SHORT).show()

                    val myIntent = Intent(this, Class04DbRoomRecyclerViewDetailActivity::class.java)
                    myIntent.putExtra("clickedCatId", cat.id.toString())
                    startActivity(myIntent)
                }
                mAdapter.notifyDataSetChanged()

                mRecyclerView.adapter = mAdapter
                mRecyclerView.layoutManager = LinearLayoutManager(this)
                mRecyclerView.setHasFixedSize(true)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            } finally {
                catRoomDatabase!!.close()
            }
        }

        val thread = Thread(r)
        thread.start()

        mAddBtn.setOnClickListener {
            val i = Intent(this, Class04DbRoomRecyclerViewAddActivity::class.java)
            startActivity(i)
            finish()
        }

        val deleteAllRunnable = Runnable {
            try {
                catRoomDatabase?.catDao()?.deleteAll()
            } catch(e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        mDeleteAllBtn.setOnClickListener {

            val alert = AlertDialog.Builder(this)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 모든 목록을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                val addThread = Thread(deleteAllRunnable)
                addThread.start()
            })

            alert.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which -> null })
            alert.show()

            return@setOnClickListener
        }
    }

    override fun onDestroy() {
        CatRoomDatabase.destroyInstance()
        catRoomDatabase = null
        super.onDestroy()
    }
}
