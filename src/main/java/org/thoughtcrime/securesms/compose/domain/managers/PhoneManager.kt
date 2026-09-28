package org.thoughtcrime.securesms.compose.domain.managers

interface PhoneManager {
    fun getSimCountryIso(): String?
}