package org.maplibre.android.geometry

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

class LatLng(val latitude: Double = 0.0, val longitude: Double = 0.0) {
    val coordinate: LatLng get() = this
}

class MapViewCamera(var position: LatLng = LatLng(), var zoom: Double = 0.0) {
    companion object {
        fun Centered(latLng: LatLng = LatLng(), zoom: Double = 0.0): MapViewCamera = MapViewCamera(latLng, zoom)
    }
}

class CameraState {
    companion object {
        fun Centered(latLng: LatLng = LatLng(), zoom: Double = 0.0): MapViewCamera = MapViewCamera(latLng, zoom)
    }
}

class MapLibreMap

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    camera: Any? = null,
    styleUrl: String = "",
    mapOptions: Any? = null,
    onTapGestureCallback: (LatLng) -> Unit = {},
    content: @Composable () -> Unit = {}
) {}

@Composable
fun Symbol(
    center: LatLng = LatLng(),
    coordinate: LatLng = LatLng(),
    imageId: Int = 0,
    size: Float = 1f
) {}

@Composable
fun rememberSaveableMapViewCamera(vararg args: Any?): MapViewCamera = remember { MapViewCamera() }
