package org.maplibre.android.geometry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class LatLng(val latitude: Double = 0.0, val longitude: Double = 0.0)
class MapViewCamera
class MapLibreMap

@Composable
fun rememberSaveableMapViewCamera(): MapViewCamera = remember { MapViewCamera() }
