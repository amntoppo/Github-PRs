package io.aman.githubprs.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.aman.githubprs.data.model.RepositoryModelItem
import io.aman.githubprs.databinding.RepositoryItemBinding
import io.aman.githubprs.view.RepositoryOnClickListener

class RepositoryAdapter(private val onClickListener: RepositoryOnClickListener) :
    ListAdapter<RepositoryModelItem, RepositoryAdapter.RepositoryViewHolder>(RepositoryComparator()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        val binding = RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem != null) {
            holder.bind(currentItem, onClickListener)
        }
    }
    class RepositoryViewHolder(private val binding: RepositoryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: RepositoryModelItem, onClickListener: RepositoryOnClickListener) {
            binding.apply {
                repositoryTitle.text = repository.name
                repositoryDescription.text = repository.description

                root.setOnClickListener {
                    onClickListener.onRepositoryClick(repository)
                }
            }
        }
    }
    class RepositoryComparator : DiffUtil.ItemCallback<RepositoryModelItem>() {
        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun areItemsTheSame(oldItem: RepositoryModelItem, newItem: RepositoryModelItem) =
            oldItem.name == newItem.name


        override fun areContentsTheSame(oldItem: RepositoryModelItem, newItem: RepositoryModelItem) =
            oldItem == newItem

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }
}


