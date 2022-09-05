package io.aman.githubprs.api

import io.aman.githubprs.data.model.PullRequestModel
import io.aman.githubprs.data.model.RepositoryModelItem
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    companion object {
        const val BASE_URL = "https://api.github.com/";
    }

    @GET("users/amntoppo/repos")
    suspend fun getRepoList(): List<RepositoryModelItem>

    @GET("/repos/amntoppo/{repositoryName}/pulls?state=closed")
    suspend fun getPRList(@Path("repositoryName") repositoryName: String): List<PullRequestModel>
}