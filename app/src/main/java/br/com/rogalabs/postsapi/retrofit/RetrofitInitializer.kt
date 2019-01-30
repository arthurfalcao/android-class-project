package br.com.rogalabs.postsapi.retrofit

import br.com.rogalabs.postsapi.retrofit.service.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    fun postService(): PostService {
        return retrofit.create(PostService::class.java)
    }
}