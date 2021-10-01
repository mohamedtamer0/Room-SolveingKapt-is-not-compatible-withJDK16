package com.example.room


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "posts_table")
class Post(var userId: Int, var title: String, var body: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}