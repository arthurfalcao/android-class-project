package br.com.rogalabs.postsapi.retrofit.service

import br.com.rogalabs.postsapi.model.Post
import br.com.rogalabs.postsapi.model.PostComment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    fun list() : Call<List<Post>>

    @GET("posts/{post_id}/comments")
    fun getComments(@Body post: Post, @Path("post_id") id: Int): Call<List<PostComment>>
}