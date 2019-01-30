package br.com.rogalabs.postsapi.retrofit.client

import android.util.Log
import br.com.rogalabs.postsapi.model.Post
import br.com.rogalabs.postsapi.model.PostComment
import br.com.rogalabs.postsapi.retrofit.RetrofitInitializer
import br.com.rogalabs.postsapi.retrofit.callback

class PostWebClient {

    fun list(success: (posts: List<Post>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {

        val call = RetrofitInitializer().postService().list()
//        call.enqueue(object: Callback<List<Post>?> {
//            override fun onResponse(call: Call<List<Post>?>,
//                                    response: Response<List<Post>?>?) {
//                response?.body()?.let {
//                    val posts: List<Post> = it
//                    success(posts)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Post>?>,
//                                   t: Throwable) {
//                Log.e("Error: ", t.message)
//            }
//        })
        call.enqueue(callback ({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun getComments(post: Post,
                    success: (postsComment: List<PostComment>) -> Unit,
                    failure: (throwable: Throwable) -> Unit) {
        Log.d("ue", "${post.id}")
//        val call = RetrofitInitializer().postService().getComments(post, post.id)
//
//        call.enqueue(callback ({ response ->
//            response?.body()?.let {
//                success(it)
//            }
//        }, { throwable ->
5626450
//                failure(it)

//            }
//        }))
    }
}