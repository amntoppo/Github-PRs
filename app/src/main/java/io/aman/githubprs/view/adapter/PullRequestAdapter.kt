package io.aman.githubprs.view.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.aman.githubprs.data.model.PullRequestModel
import io.aman.githubprs.databinding.PullrequestItemBinding
import io.aman.githubprs.utils.getFormattedDate

class PullRequestAdapter: ListAdapter<PullRequestModel, PullRequestAdapter.PullRequestViewHolder>(PullRequestComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val binding = PullrequestItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PullRequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem != null) {
            holder.bind(currentItem)
        }
    }
    class PullRequestViewHolder(private val binding: PullrequestItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: PullRequestModel) {
            binding.apply {
                prTitle.text = currentItem.title
                prUsername.text = currentItem.user.login
                prCreatedOn.text = getFormattedDate(currentItem.created_at)
                if(!currentItem.closed_at.isNullOrEmpty()) {
                    prClosedon.isVisible = true
                    prClosedon.text = getFormattedDate(currentItem.closed_at)
                }
                Glide.with(itemView)
                    .load(currentItem.user.avatar_url)
                    .into(prImage)
                //prContactNumber.text = currentItem.
            }
        }
    }


    class PullRequestComparator: DiffUtil.ItemCallback<PullRequestModel>() {
        override fun areItemsTheSame(newItem: PullRequestModel, oldItem: PullRequestModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PullRequestModel, newItem: PullRequestModel) =
            oldItem == newItem
    }
}