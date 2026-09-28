package com.maplibre.compose.camera

import org.maplibre.android.geometry.LatLng

class MapViewCamera(var position: LatLng = LatLng(), var zoom: Double = 0.0)

object CameraState {
    fun Centered(latLng: LatLng = LatLng(), zoom: Double = 0.0): MapViewCamera = MapViewCamera(latLng, zoom)
}
