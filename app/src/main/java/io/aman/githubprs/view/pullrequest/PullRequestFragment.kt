package io.aman.githubprs.view.pullrequest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.aman.githubprs.R
import io.aman.githubprs.databinding.FragmentPullrequestBinding
import io.aman.githubprs.view.adapter.PullRequestAdapter

@AndroidEntryPoint
class PullRequestFragment: Fragment() {

    private val viewModel: PullRequestViewModel by viewModels()
    private var repositoryName: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPullrequestBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val pullRequestAdapter = PullRequestAdapter()
        val bundle: Bundle? = this.arguments
        repositoryName = bundle?.getString("repository_name")
        binding.apply {
            pullrequestRecyclerView.apply {
                adapter = pullRequestAdapter
                layoutManager = LinearLayoutManager(this@PullRequestFragment.context)
            }
            repositoryName?.let {
                viewModel.getPRList(it).observe(viewLifecycleOwner) { PR ->
                    if(PR.isNullOrEmpty()) {
                        textViewError.isVisible = true
                        textViewError.text = context?.getString(R.string.empty_pull_request)
                    }
                    pullRequestAdapter.submitList(PR)
                }
            }
        }

        return root
    }
}