package io.aman.githubprs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.aman.githubprs.R
import io.aman.githubprs.data.model.RepositoryModelItem
import io.aman.githubprs.databinding.ActivityMainBinding
import io.aman.githubprs.view.adapter.RepositoryAdapter
import io.aman.githubprs.viewmodel.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewmodel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val repositoryAdapter = RepositoryAdapter(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

//        binding.apply {
//            repositoryRecyclerView.apply {
//                adapter = repositoryAdapter
//                layoutManager = LinearLayoutManager(this@MainActivity)
//            }
//            viewmodel.repository.observe(this@MainActivity) {
//                Log.e("github", it[0].archive_url)
//                repositoryAdapter.submitList(it)
//            }
//        }


    }

}