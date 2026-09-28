package com.maplibre.compose.symbols

import androidx.compose.runtime.Composable
import org.maplibre.android.geometry.LatLng

@Composable
fun Symbol(
    center: LatLng = LatLng(),
    coordinate: LatLng = LatLng(),
    imageId: Int = 0,
    size: Float = 1f
) {}
