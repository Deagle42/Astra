package org.thoughtcrime.securesms.compose.maplibre

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

class MapViewCamera
class LatLng(val latitude: Double, val longitude: Double)

@Composable
fun rememberSaveableMapViewCamera(): MapViewCamera {
    return remember { MapViewCamera() }
}
