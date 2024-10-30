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
fun CongestionCriteriaScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val guidelineTop07 = createGuidelineFromTop(0.07f)
        val guidelineTop09 = createGuidelineFromTop(0.09f)


        val (
            headerRef,
            boxLabelRef,
            dividerRef,
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
                text = "혼잡도 기준",
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
            Image(
                painter = painterResource(Res.drawable.ic_sensor_example),
                contentDescription = "ic_sensor_example",
            )
            Spacer(Modifier.height(24.dp))

            Text(
                text = "방식",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "정류장 대기줄 옆 나무에 초음파 센서를 달아 감지합니다.  지나가는\n사람들과 줄을 선 사람들을 구분을 하지만 아직 완벽하지는 않습니다!",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = "혼잡도 기준",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )
        
            Spacer(Modifier.height(12.dp))

            Text(
                text = "센서가 달린 나무의 위치를 통해 구분합니다. 정류장과 먼 나무의 센서에\n서 감지될 수록 혼잡도가 높은 것으로 판단합니다. 아래는 저희가 정한 임\n의의 기준입니다.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = pretendardFontFamily
                ),
                color = Color.Black,
            )

            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                CustomBox(Color(0xff000000).copy(alpha = 0.12f),
                    text = "여유",
                    textColor = Color(0xff000000))

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "무조건 탈 수 있어요.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color.Black
                )
            }

            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                CustomBox(Color(0xffEEE8FF),
                    text = "보통",
                    textColor = Color(0xff42023B))

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "좌석에 앉을 수는 없어도 탈 수는 있을 거예요.",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = pretendardFontFamily
                    ),
                    color = Color.Black
                )
            }

            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                CustomBox(Color(0xffFF9090).copy(alpha = 0.20f),
                    text = "혼잡",
                    textColor = Color(0xff42023B))

                Spacer(Modifier.width(8.dp))

                Text(
                    text = "다음 버스를 타야 할 수도 있어요.",
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

@Composable
fun CustomBox(
    boxColor: Color,
    textColor: Color,
    text: String
) {
    Box(
        modifier = Modifier
            .background(
                color = boxColor, // 전달받은 색상
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp, 2.dp, 6.dp, 2.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = pretendardFontFamily
            ),
            color = textColor
        )
    }
}