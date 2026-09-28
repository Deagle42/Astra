package org.thoughtcrime.securesms.compose.domain.models

data class GitHubCommitModel(
    val sha: String,
    val message: String,
    val authorName: String,
    val committedAt: String,
    val htmlUrl: String
)
