package com.jisu.kotlindemoapp.class04

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.adapter.WordListAdapter
import com.jisu.kotlindemoapp.class04.entity.Word
import com.jisu.kotlindemoapp.class04.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_class04_db_room_word_content_main.*
import kotlinx.android.synthetic.main.activity_class04_db_room_word_main.*


class Class04DbRoomWordMainActivity : AppCompatActivity() {

    companion object {
        val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_room_word_main)
        setSupportActionBar(toolbar)

        val adapter = WordListAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
        wordViewModel.getAllWords().observe(this, Observer<List<Word>> { words ->
            adapter.setWords(words)
        })

        fab.setOnClickListener {
            val intent = Intent(this, Class04DbRoomWordNewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            val word = Word(data!!.getStringExtra(Class04DbRoomWordNewWordActivity.EXTRA_REPLY))
            wordViewModel.insert(word)
        } else {
            Toast.makeText(applicationContext, "Word not saved because it is empty",
                Toast.LENGTH_LONG).show()
        }
    }
}
