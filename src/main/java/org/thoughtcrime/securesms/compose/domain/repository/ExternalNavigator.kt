package org.thoughtcrime.securesms.compose.domain.repository

interface ExternalNavigator {
    fun openUrl(url: String)
    val packageName: String
    fun navigateToLinkSettings()
    fun openOssLicenses()
}