package com.jisu.kotlindemoapp.class04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.database.CatRoomDatabase
import com.jisu.kotlindemoapp.class04.entity.Cat
import kotlinx.android.synthetic.main.activity_class04_db_room_recycler_view_detail.*

class Class04DbRoomRecyclerViewDetailActivity : BaseActivity() {

    lateinit var mCat:Cat
    private var catRoomDatabase : CatRoomDatabase? = null
    private var clickedCatId:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_room_recycler_view_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        catRoomDatabase = CatRoomDatabase.getInstance(this)

        val editRunnable = Runnable {
            try {
                val updateCat = Cat()
                updateCat.id = targetId.text.toString().toLong()
                updateCat.catName = editName.text.toString()
                updateCat.lifeSpan = editLifeSpan.text.toString().toInt()
                updateCat.origin = editOrigin.text.toString()
                catRoomDatabase?.catDao()?.update(updateCat)

            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            } finally {
                catRoomDatabase!!.close()
            }
        }

        val deleteRunnable = Runnable {
            try {
                val deleteCat = Cat()
                deleteCat.id = targetId.text.toString().toLong()
                catRoomDatabase?.catDao()?.delete(deleteCat)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        editBtn.setOnClickListener {
            val addThread = Thread(editRunnable)
            addThread.start()

            val i = Intent(this, Class04DbRoomRecyclerViewActivity::class.java)
            startActivity(i)
            finish()
        }

        deleteBtn.setOnClickListener {
            val addThread = Thread(deleteRunnable)
            addThread.start()

            val i = Intent(this, Class04DbRoomRecyclerViewActivity::class.java)
            startActivity(i)
            finish()
        }

    }

    override fun setValues() {

        catRoomDatabase = CatRoomDatabase.getInstance(this)
        clickedCatId = intent.getStringExtra("clickedCatId").toLong()

        // 리스트에서 클릭한 id의 정보 조회
        val selectClickedRunnable = Runnable {
            try {

                mCat = catRoomDatabase?.catDao()?.select(clickedCatId) as Cat

                targetId.setText(mCat.id.toString())
                editName.setText(mCat.catName.toString())
                editLifeSpan.setText(mCat.lifeSpan.toString())
                editOrigin.setText(mCat.origin.toString())

            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            } finally {
                catRoomDatabase!!.close()
            }
        }

        val addThread = Thread(selectClickedRunnable)
        addThread.start()
    }
}
