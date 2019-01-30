package br.com.rogalabs.postsapi.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.rogalabs.postsapi.R
import br.com.rogalabs.postsapi.model.Post
import br.com.rogalabs.postsapi.retrofit.client.PostWebClient

class PostDialog(
        private val viewGroup: ViewGroup,
        private val context: Context) {

    private val createdView = createView()

    fun list(post: Post, listed: (listedPost: Post) -> Unit) {

        PostWebClient().getComments(post, {
            Toast.makeText(context, "Falha $it", Toast.LENGTH_LONG).show()
        }, {
            Toast.makeText(context, "Falha ao buscar comentarios", Toast.LENGTH_LONG).show()
        })
    }

    private fun createView(): View {
        return LayoutInflater.from(context)
                .inflate(R.layout.details_post,
                        viewGroup,
                        false)
    }
}