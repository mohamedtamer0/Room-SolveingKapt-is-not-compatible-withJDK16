package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao?

    companion object {
        private var instance: PostsDatabase? = null
        @Synchronized
        fun getInstance(context: Context): PostsDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostsDatabase::class.java, "posts_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}