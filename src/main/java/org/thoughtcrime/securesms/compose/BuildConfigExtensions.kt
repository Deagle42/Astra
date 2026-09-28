package org.thoughtcrime.securesms.compose

import org.thoughtcrime.securesms.BuildConfig

val BuildConfig.ENABLE_TELEMT_DNS: Boolean get() = false
val BuildConfig.IS_OFFICIAL_TDLIB: Boolean get() = true
val BuildConfig.IS_LIBRE_RUNTIME: Boolean get() = false
val BuildConfig.HAS_OSS_LICENSES: Boolean get() = false
val BuildConfig.BUILD_BRANCH: String get() = "main"
val BuildConfig.BUILD_COMMIT_HASH: String get() = "1.0.0"
val BuildConfig.BUILD_TIME_MILLIS: Long get() = 0L
