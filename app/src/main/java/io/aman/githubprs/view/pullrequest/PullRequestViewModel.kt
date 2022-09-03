package io.aman.githubprs.view.pullrequest

import androidx.lifecycle.ViewModel
import io.aman.githubprs.api.GithubApi
import javax.inject.Inject

class PullRequestViewModel @Inject constructor(
    private val api: GithubApi
): ViewModel() {

    init {

    }
}