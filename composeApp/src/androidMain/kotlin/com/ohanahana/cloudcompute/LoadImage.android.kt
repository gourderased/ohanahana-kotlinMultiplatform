package com.ohanahana.cloudcompute

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
actual fun LoadImage(resourceName: String, contentDescription: String?, modifier: Modifier) {
    val resId = when (resourceName) {
        "bg_splash" -> R.drawable.bg_splash
        "ic_logo" -> R.drawable.ic_logo
        "ic_refresh" -> R.drawable.ic_refresh
        "ic_logo_home_congestion" -> R.drawable.ic_logo_home_congestion
        "ic_arrow" -> R.drawable.ic_arrow
        "ic_line" -> R.drawable.ic_line
        else -> R.drawable.ic_logo
    }

    Image(
        painter = painterResource(resId),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}