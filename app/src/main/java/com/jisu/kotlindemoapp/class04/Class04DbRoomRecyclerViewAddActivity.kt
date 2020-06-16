package com.jisu.kotlindemoapp.class04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.database.CatDB
import com.jisu.kotlindemoapp.class04.entity.Cat
import kotlinx.android.synthetic.main.activity_class04_db_room_recycler_view_add.*
import java.lang.reflect.Executable

class Class04DbRoomRecyclerViewAddActivity : AppCompatActivity() {

    private var catDb : CatDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_room_recycler_view_add)

        catDb = CatDB.getInstance(this)

        /* 새로운 cat 객체를 생성, id 이외의 값을 지정 후 DB에 추가 */
        val addRunnable = Runnable {
            try {
                val newCat = Cat()
                newCat.catName = addName.text.toString()
                newCat.lifeSpan = addLifeSpan.text.toString().toInt()
                newCat.origin = addOrigin.text.toString()
                catDb?.catDao()?.insert(newCat)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            } finally {
                catDb!!.close()
            }
        }

        addBtn.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()

            val i = Intent(this, Class04DbRoomRecyclerViewActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onDestroy() {
        CatDB.destroyInstance()
        super.onDestroy()
    }
}
