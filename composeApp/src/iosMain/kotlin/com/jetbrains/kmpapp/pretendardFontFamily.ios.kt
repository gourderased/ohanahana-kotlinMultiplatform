package com.jetbrains.kmpapp

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual val pretendardFontFamily: FontFamily = FontFamily(
    Font(
        identity = "Pretendard-Regular",
        data = loadFontData("Pretendard-Regular.ttf"),
        weight = FontWeight.Normal
    ),
    Font(
        identity = "Pretendard-SemiBold",
        data = loadFontData("Pretendard-SemiBold.ttf"),
        weight = FontWeight.SemiBold
    )
)