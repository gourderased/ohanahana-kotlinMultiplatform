package com.ohana.cloudcompute.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.ohana.cloudcompute.LoadImage
import com.ohana.cloudcompute.pretendardFontFamily

@Composable
fun MainFeatureScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val guidelineTop07 = createGuidelineFromTop(0.07f)
        val guidelineTop09 = createGuidelineFromTop(0.09f)
        val guidelineTop13 = createGuidelineFromTop(0.13f)
        val guidelineTop25 = createGuidelineFromTop(0.25f)
        val guidelineTop30 = createGuidelineFromTop(0.30f)

        // 헤더
        Box(
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(guidelineTop07)
                    bottom.linkTo(guidelineTop09)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .background(Color(0xffFEFEFE))
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)) {

            LoadImage("ic_arrow", "ic_arrow", Modifier.align(Alignment.CenterStart).clickable { navController.navigateUp() })

            Text(
                text = "주요 기능",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = "주요 기능 화면"
        )

    }
}

