package com.codebay.kotlinapi.repository

import com.codebay.kotlinapi.api.RetrofitInstance
import com.codebay.kotlinapi.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}