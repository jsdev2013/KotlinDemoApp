package com.jisu.kotlindemoapp.class04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.database.CatDB
import com.jisu.kotlindemoapp.class04.entity.Cat
import kotlinx.android.synthetic.main.activity_class04_db_room_recycler_view_add.*
import kotlinx.android.synthetic.main.activity_class04_db_room_recycler_view_detail.*

class Class04DbRoomRecyclerViewDetailActivity : BaseActivity() {

    lateinit var mCat:Cat
    private var catDb : CatDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_room_recycler_view_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        catDb = CatDB.getInstance(this)

        val editRunnable = Runnable {
            try {
                val updateCat = Cat()
                updateCat.id = targetId.text.toString().toLong()
                updateCat.catName = editName.text.toString()
                updateCat.lifeSpan = editLifeSpan.text.toString().toInt()
                updateCat.origin = editOrigin.text.toString()
                catDb?.catDao()?.update(updateCat)

            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            } finally {
                catDb!!.close()
            }
        }

        val deleteRunnable = Runnable {
            try {
                val deleteCat = Cat()
                deleteCat.id = targetId.text.toString().toLong()
                catDb?.catDao()?.delete(deleteCat)
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
        mCat = intent.getSerializableExtra("catData") as Cat

        var id = mCat.id.toString()
        val catName = mCat.catName
        val lifeSpan = mCat.lifeSpan.toString()
        val origin = mCat.origin

        targetId.setText(id)
        editName.setText(catName)
        editLifeSpan.setText(lifeSpan)
        editOrigin.setText(origin)
    }
}
