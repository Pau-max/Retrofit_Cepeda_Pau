package com.example.retrofit_cepeda_pau

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Post(val id: Int, val title: String, val body: String)
data class Comment(val id: Int, val name: String, val body: String)

interface JsonPlaceholderApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") id: Int): List<Comment>
}

object RetrofitClient {
    val api: JsonPlaceholderApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceholderApi::class.java)
    }
}