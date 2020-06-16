package com.jisu.kotlindemoapp.class04.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "cat")
class Cat(@PrimaryKey(autoGenerate = true) var id: Long?,
          @ColumnInfo(name = "catname") var catName: String?,
          @ColumnInfo(name = "lifespan") var lifeSpan: Int,
          @ColumnInfo(name = "origin") var origin: String
) : Serializable {
    constructor(): this(null,"", 0,"")
}