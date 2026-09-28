package org.thoughtcrime.securesms.compose.domain.managers

interface DistrManager {
    fun isGmsAvailable(): Boolean
    fun isFcmAvailable(): Boolean
    fun isUnifiedPushDistributorAvailable(): Boolean
    fun isInstalledFromGooglePlay(): Boolean
}