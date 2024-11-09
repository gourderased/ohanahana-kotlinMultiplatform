package com.ohanahana.cloudcompute.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun GlobalLoadingScreen() {
    val isLoading = LoadingState.isLoading.collectAsState().value

    if (isLoading) {
        Dialog(
            onDismissRequest = { LoadingState.hide() },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            )
        ) {


            Box(

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(24.dp) // 내부 패딩 추가
                ) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "새로고침 중입니다",
                        color = Color.White, // 텍스트 색상
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

        }
    }
}