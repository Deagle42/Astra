package com.maplibre.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.maplibre.compose.camera.MapViewCamera
import org.maplibre.android.geometry.LatLng

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    camera: Any? = null,
    styleUrl: String = "",
    mapOptions: Any? = null,
    onTapGestureCallback: ((LatLng) -> Unit)? = null,
    content: @Composable () -> Unit = {}
) {}

@Composable
fun rememberSaveableMapViewCamera(vararg args: Any?): MapViewCamera = remember { MapViewCamera() }
