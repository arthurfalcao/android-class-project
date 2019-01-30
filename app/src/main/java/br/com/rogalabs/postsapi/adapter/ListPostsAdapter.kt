package br.com.rogalabs.postsapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rogalabs.postsapi.R
import br.com.rogalabs.postsapi.model.Post
import kotlinx.android.synthetic.main.post_item.view.*

class ListPostsAdapter(private val posts: List<Post>,
                       private val context: Context,
                       private val onItemClickListener: (post: Post, position: Int) -> Unit) : Adapter<ListPostsAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        val post = posts[position]
        p0.let {
            it.bindView(post)
            it.itemView.setOnClickListener {
                onItemClickListener(post, position)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(post: Post) {
            val title = itemView.post_item_title
            val body = itemView.post_item_body

            title.text = post.title
            body.text = post.body
        }
    }
}

