package com.ohana.cloudcompute

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_splash
import kmp_app_template.composeapp.generated.resources.ic_logo
import org.jetbrains.compose.resources.painterResource


@Composable
actual fun LoadImage(resourceName: String, contentDescription: String?, modifier: Modifier) {
    val painter = when (resourceName) {
        "bg_splash" -> painterResource(Res.drawable.bg_splash)
        "ic_logo" -> painterResource(Res.drawable.ic_logo)
        else -> painterResource(Res.drawable.bg_splash) // 기본값 설정
    }
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}