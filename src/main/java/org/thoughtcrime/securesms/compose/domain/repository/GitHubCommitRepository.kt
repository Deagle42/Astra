package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.GitHubCommitModel

interface GitHubCommitRepository {
    suspend fun getRecentCommits(
        branchOrSha: String,
        limit: Int = 20
    ): Result<List<GitHubCommitModel>>
}
