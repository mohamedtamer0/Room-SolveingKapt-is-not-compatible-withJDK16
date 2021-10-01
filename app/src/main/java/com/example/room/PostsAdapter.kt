package com.example.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    private var postList: List<Post> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.titleTV.setText(postList[position].title)
        holder.bodyTV.setText(postList[position].body)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setList(posts: List<Post>) {
        postList = posts
        notifyDataSetChanged()
    }

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTV: TextView
        val bodyTV: TextView

        init {
            titleTV = itemView.findViewById(R.id.item_title_textView)
            bodyTV = itemView.findViewById(R.id.item_body_textView)
        }
    }
}