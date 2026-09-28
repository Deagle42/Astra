package org.thoughtcrime.securesms.compose.settings.about
import org.thoughtcrime.securesms.BuildConfig

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.thoughtcrime.securesms.compose.domain.models.GitHubCommitModel
import org.thoughtcrime.securesms.compose.domain.models.UpdateState
import org.thoughtcrime.securesms.compose.domain.repository.GitHubCommitRepository
import org.thoughtcrime.securesms.compose.domain.repository.UpdateRepository
import org.thoughtcrime.securesms.compose.BuildConfig
import org.thoughtcrime.securesms.compose.core.util.componentScope
import org.thoughtcrime.securesms.compose.root.AppComponentContext

data class RecentCommitsState(
    val isVisible: Boolean = false,
    val isLoading: Boolean = false,
    val commits: List<GitHubCommitModel> = emptyList(),
    val errorMessage: String? = null
)

interface AboutComponent {
    val updateState: StateFlow<UpdateState>
    val tdLibVersion: StateFlow<String>
    val tdLibCommitHash: StateFlow<String>
    val recentCommitsState: StateFlow<RecentCommitsState>
    val buildBranch: String
    val buildCommitHash: String
    val buildTimeMillis: Long
    val currentCommitUrl: String?
    val hasOpenSourceLicenses: Boolean
    fun onBackClicked()
    fun checkForUpdates()
    fun downloadUpdate()
    fun installUpdate()
    fun onRecentCommitsClicked()
    fun onRecentCommitsDismissed()
    fun retryRecentCommits()
    fun onTermsOfServiceClicked()
    fun onOpenSourceLicensesClicked()
}
