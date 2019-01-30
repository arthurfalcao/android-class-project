package br.com.rogalabs.postsapi.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import br.com.rogalabs.postsapi.R
import br.com.rogalabs.postsapi.adapter.ListPostsAdapter
import br.com.rogalabs.postsapi.model.Post
import br.com.rogalabs.postsapi.retrofit.client.PostWebClient
import br.com.rogalabs.postsapi.ui.dialog.PostDialog
import kotlinx.android.synthetic.main.activity_list_posts.*

class ListPostsActivity : AppCompatActivity() {

    private val posts: MutableList<Post> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_posts)

//        PostWebClient().list(object : CallbackResponse<List<Post>> {
//            override fun success(posts: List<Post>) {
//                this@ListPostsActivity.posts.addAll(posts)
//                configureList()
//            }
//        })

        PostWebClient().list ({
            this.posts.addAll(it)
            configureList()
        }, {
            Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
        })
    }

    private fun configureList() {
        val recyclerView = post_list_recyclerview

        val createdView = LayoutInflater.from(this).inflate(R.layout.details_post,
                window.decorView as ViewGroup,
                false)

        recyclerView.adapter = ListPostsAdapter(posts, this) { post, position ->

            PostWebClient().getComments(post, {
                Toast.makeText(this, "Estou", Toast.LENGTH_LONG).show()
            }, {
                Toast.makeText(this, "Falha ao buscar comentarios", Toast.LENGTH_LONG).show()
            })
//            PostDialog(window.decorView as ViewGroup, this).list(post) {
//                posts[position] = it
//                configureList()
//            }
        }

        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
