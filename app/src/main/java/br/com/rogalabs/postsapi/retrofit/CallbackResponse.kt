package br.com.rogalabs.postsapi.retrofit


interface CallbackResponse<T> {
    fun success(response: T)
}