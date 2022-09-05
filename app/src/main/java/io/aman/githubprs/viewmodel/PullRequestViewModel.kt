package io.aman.githubprs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aman.githubprs.api.GithubApi
import io.aman.githubprs.data.model.PullRequestModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PullRequestViewModel @Inject constructor(
    private val api: GithubApi
): ViewModel() {
    private val PRLiveData = MutableLiveData<List<PullRequestModel>>()
    val PullRequest: LiveData<List<PullRequestModel>> = PRLiveData


    fun getPRList(repositoryName: String): LiveData<List<PullRequestModel>> {
        viewModelScope.launch {
            val PRList = api.getPRList(repositoryName)
            PRLiveData.value = PRList
        }
        return PRLiveData
    }
}