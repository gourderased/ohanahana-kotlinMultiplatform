package com.ohanahana.cloudcompute

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual val pretendardFontFamily: FontFamily = FontFamily(
    //Regular - 400
    Font(
        identity = "Pretendard-Regular",
        data = loadFontData("Pretendard-Regular.ttf"),
        weight = FontWeight.Normal
    ),
    //Medium - 500
    Font(
        identity = "Pretendard-Medium",
        data = loadFontData("Pretendard-Medium.ttf"),
        weight = FontWeight.Medium
    ),
    //Semibold - 600
    Font(
        identity = "Pretendard-SemiBold",
        data = loadFontData("Pretendard-SemiBold.ttf"),
        weight = FontWeight.SemiBold
    ),

    //Bold - 700
    Font(
        identity = "Pretendard-Bold",
        data = loadFontData("Pretendard-Bold.ttf"),
        weight = FontWeight.Bold
    )
)