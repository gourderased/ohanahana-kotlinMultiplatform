package com.ohana.cloudcompute.screens.projectinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Divider
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
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.ic_sensor_example
import org.jetbrains.compose.resources.painterResource

@Composable
fun ExpectedPeopleTimeScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val guidelineTop07 = createGuidelineFromTop(0.07f)
        val guidelineTop09 = createGuidelineFromTop(0.09f)


        val (
            headerRef,
            boxLabelRef,
        ) = createRefs()

        // 헤더
        Box(
            modifier = Modifier
                .constrainAs(headerRef) {
                    top.linkTo(guidelineTop07)
                    bottom.linkTo(guidelineTop09)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .background(Color(0xffFEFEFE))
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)) {

            LoadImage(
                "ic_arrow",
                "ic_arrow",
                Modifier.align(Alignment.CenterStart).clickable { navController.navigateUp() })

            Text(
                text = "프로젝트 소개 및 이용 안내",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        //이용 안내
        Column(
            modifier = Modifier
                .constrainAs(boxLabelRef) {
                    top.linkTo(headerRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "이용 안내",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))
            Text(
                text = "예상 대기 인원 및 대기 시간",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "2024.10.28",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color(0xff666666),
            )
        }

        Divider(
            color = Color(0xffF1F1F1),
            thickness = 1.dp,
            modifier = Modifier
                .constrainAs(createRef()) {
                    top.linkTo(boxLabelRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(horizontal = 24.dp)

        )

        //프로젝트 설명
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = 24.dp)
                .constrainAs(createRef()) {
                    top.linkTo(boxLabelRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "예상 대기 인원",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "예상 대기 인원은 추정치예요. 실제 대기줄에 따라 달라질 수 있어요.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = "예상 대기 시간",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                CustomBox(Color(0xff000000).copy(alpha = 0.12f),
                    text = "여유",
                    textColor = Color(0xff000000))

                Spacer(Modifier.width(4.dp))

                CustomBox(Color(0xffEEE8FF),
                    text = "보통",
                    textColor = Color(0xff42023B))

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "지금 오고 있는 511버스의 대기시간을 표시해요.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color.Black
                )
            }

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                CustomBox(Color(0xffFF9090).copy(alpha = 0.20f),
                    text = "혼잡",
                    textColor = Color(0xff42023B))

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "현재 버스를 보내고 그 다음 511버스의 시간까지를 보여드리고\n있어요.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color.Black
                )
            }

        }
    }
}