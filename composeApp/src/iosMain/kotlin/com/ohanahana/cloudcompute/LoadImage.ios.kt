package com.ohanahana.cloudcompute

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_splash
import kmp_app_template.composeapp.generated.resources.ic_logo
import kmp_app_template.composeapp.generated.resources.ic_logo_home_congestion
import kmp_app_template.composeapp.generated.resources.ic_refresh
import kmp_app_template.composeapp.generated.resources.ic_arrow
import kmp_app_template.composeapp.generated.resources.ic_line
import org.jetbrains.compose.resources.painterResource


@Composable
actual fun LoadImage(resourceName: String, contentDescription: String?, modifier: Modifier) {
    val painter = when (resourceName) {
        "bg_splash" -> painterResource(Res.drawable.bg_splash)
        "ic_refresh" -> painterResource(Res.drawable.ic_refresh)
        "ic_logo" -> painterResource(Res.drawable.ic_logo)
        "ic_logo_home_congestion" -> painterResource(Res.drawable.ic_logo_home_congestion)
        "ic_arrow" -> painterResource(Res.drawable.ic_arrow)
        "ic_line" -> painterResource(Res.drawable.ic_line)
        else -> painterResource(Res.drawable.bg_splash) // 기본값 설정
    }
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}