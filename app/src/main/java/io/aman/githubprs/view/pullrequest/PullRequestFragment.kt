package io.aman.githubprs.view.pullrequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.aman.githubprs.databinding.FragmentPullrequestBinding

class PullRequestFragment: Fragment() {

    private val viewModel: PullRequestViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPullrequestBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }
}