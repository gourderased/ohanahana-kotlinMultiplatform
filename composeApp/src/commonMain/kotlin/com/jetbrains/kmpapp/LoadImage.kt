package com.jetbrains.kmpapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun LoadImage(resourceName: String, contentDescription: String?, modifier: Modifier = Modifier)