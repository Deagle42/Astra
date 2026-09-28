package org.maplibre.compose.expressions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

class LatLng(val latitude: Double = 0.0, val longitude: Double = 0.0)
class MapViewCamera(var position: LatLng = LatLng(), var zoom: Double = 0.0)
class MapLibreMap

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    camera: MapViewCamera = MapViewCamera(),
    content: @Composable () -> Unit = {}
) {}

@Composable
fun Symbol(
    center: LatLng = LatLng(),
    coordinate: LatLng = LatLng()
) {}

@Composable
fun rememberSaveableMapViewCamera(vararg args: Any?): MapViewCamera = remember { MapViewCamera() }
