package org.thoughtcrime.securesms.compose.domain.repository

import org.thoughtcrime.securesms.compose.domain.models.webapp.OSMReverseResponse

interface LocationRepository {
    suspend fun reverseGeocode(lat: Double, lon: Double): OSMReverseResponse?
}