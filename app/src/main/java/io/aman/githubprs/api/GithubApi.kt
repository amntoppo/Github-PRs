package io.aman.githubprs.api

import io.aman.githubprs.data.model.RepositoryModelItem
import retrofit2.http.GET

interface GithubApi {

    companion object {
        const val BASE_URL = "https://api.github.com/";
    }

    @GET("users/amntoppo/repos")
    suspend fun getPRList(): List<RepositoryModelItem>
}