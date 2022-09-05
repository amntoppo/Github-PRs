package io.aman.githubprs.view.repository

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.aman.githubprs.R
import io.aman.githubprs.data.model.RepositoryModelItem
import io.aman.githubprs.databinding.FragmentRepositoryBinding
import io.aman.githubprs.view.RepositoryOnClickListener
import io.aman.githubprs.view.adapter.RepositoryAdapter

@AndroidEntryPoint
class RepositoryFragment: Fragment(), RepositoryOnClickListener {
    private val viewModel: RepositoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val repositoryAdapter = RepositoryAdapter(this)
        binding.apply {
            repositoryRecyclerView.apply {
                adapter = repositoryAdapter
                layoutManager = LinearLayoutManager(this@RepositoryFragment.context)
            }
            viewModel.repository.observe(viewLifecycleOwner) {

                Log.e("github", it[0].pulls_url)
                repositoryAdapter.submitList(it)
            }
        }
        return root
    }

    override fun onRepositoryClick(modelItem: RepositoryModelItem) {
        val bundle = Bundle()
        bundle.putString("repository_name", modelItem.name)
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navHostFragment.navController.navigate(R.id.action_navigation_repository_to_navigation_pullrequest, bundle)
        Log.e("github", modelItem.pulls_url)
        Toast.makeText(this@RepositoryFragment.context, modelItem.name, Toast.LENGTH_LONG).show()
    }
}