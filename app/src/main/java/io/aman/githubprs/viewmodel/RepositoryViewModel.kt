package io.aman.githubprs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aman.githubprs.api.GithubApi
import io.aman.githubprs.data.model.RepositoryModelItem
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val api: GithubApi
): ViewModel() {

    private val RepositoryLiveData = MutableLiveData<List<RepositoryModelItem>>()
    val repository: LiveData<List<RepositoryModelItem>> = RepositoryLiveData

    init {
        viewModelScope.launch {
            val respository = api.getRepoList()
            RepositoryLiveData.value = respository
        }
    }
}