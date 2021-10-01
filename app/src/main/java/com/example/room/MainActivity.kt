package com.example.room

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var postsRecyclerView = findViewById<RecyclerView>(R.id.posts_recyclerView)

        var insertBtn = findViewById<Button>(R.id.insertButton)
        var getBtn = findViewById<Button>(R.id.getBuuton)
        var titleEt = findViewById<EditText>(R.id.editTextTextTitle)
        var bodyEt = findViewById<EditText>(R.id.editTextTextBody)


        val adapter = PostsAdapter()
        postsRecyclerView.adapter = adapter

        val postsDatabase = PostsDatabase.getInstance(this)


        insertBtn.setOnClickListener {
            postsDatabase!!.postsDao()!!.insertPost(Post(2, titleEt.editableText.toString(), bodyEt.editableText.toString()))
                ?.subscribeOn(Schedulers.computation())
                ?.subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onComplete() {}
                    override fun onError(e: Throwable) {}
                })
        }


        getBtn.setOnClickListener {
            postsDatabase!!.postsDao()!!.getPosts()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Post?>> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onSuccess(posts: List<Post?>) {
                        adapter.setList(posts as List<Post>)
                        adapter.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {}
                })
        }

    }



}