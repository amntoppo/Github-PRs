package io.aman.githubprs.view

import io.aman.githubprs.data.model.RepositoryModelItem

interface RepositoryOnClickListener {

    fun onRepositoryClick(modelItem: RepositoryModelItem);
}