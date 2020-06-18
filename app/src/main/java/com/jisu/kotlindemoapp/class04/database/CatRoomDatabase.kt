package com.jisu.kotlindemoapp.class04.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jisu.kotlindemoapp.class04.dao.CatDao
import com.jisu.kotlindemoapp.class04.entity.Cat

@Database(entities = [Cat::class], version = 1)
abstract class CatRoomDatabase: RoomDatabase() {
    abstract fun catDao(): CatDao

    companion object {
        private var INSTANCE: CatRoomDatabase? = null

        fun getInstance(context: Context): CatRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(CatRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CatRoomDatabase::class.java, "cat.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}