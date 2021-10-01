package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single



@Dao
interface PostsDao {
    @Insert
    fun insertPost(post: Post?): Completable?

    @Query("select * from posts_table")
    fun getPosts(): Single<List<Post>>
}