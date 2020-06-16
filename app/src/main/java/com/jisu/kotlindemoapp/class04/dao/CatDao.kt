package com.jisu.kotlindemoapp.class04.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.jisu.kotlindemoapp.class04.entity.Cat

@Dao
interface CatDao {
    @Query("SELECT * FROM cat")
    fun getAll(): List<Cat>

    /* import android.arch.persistence.room.OnConflictStrategy.REPLACE */
    @Insert(onConflict = REPLACE)
    fun insert(cat: Cat)

    @Update
    fun update(cat : Cat)

    @Delete
    fun delete(cat :Cat)

    @Query("DELETE from cat")
    fun deleteAll()
}