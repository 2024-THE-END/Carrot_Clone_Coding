package the.end2024.carrotclone.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import the.end2024.carrotclone.R
import the.end2024.carrotclone.presentation.nav.NavigationManager.navController
import the.end2024.carrotclone.presentation.theme.CarrotCloneTheme
import the.end2024.carrotclone.presentation.theme.gMarket_bold
import the.end2024.carrotclone.presentation.theme.gMarket_light
import the.end2024.carrotclone.presentation.theme.gMarket_medium

class startActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrotCloneTheme {

            }
        }
    }
}

@Composable
fun screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        mainBanner()
        startImage()
        explainText()
        setMyLoc()
    }
}

@Composable
fun setMyLoc() {
    Button(
        onClick = {
            navController.navigate("firstUser")
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE78111),
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(
            text = "내 동네 설정하고 시작하기",
            color = Color.White
        )
    }
}

@Composable
fun explainText() {
    Text(
        text = "우리 동네 중고 직거래 당근마켓",
        color = Color.Black,
        fontSize = 20.sp,
        fontFamily = gMarket_medium
    )

    Spacer(modifier = Modifier.padding(10.dp))
    Text(
        text = "당근마켓은 동네 직거래 마켓이에요.\n내 동네를 설정하고 시작해보세요!",
        color = Color.Black,
        fontSize = 16.sp,
        fontFamily = gMarket_light
    )

    Spacer(modifier = Modifier.padding(20.dp))
}

@Composable
fun startImage() {
    Image(
        painter = painterResource(id = R.drawable.icon_start_logo),
        contentDescription = "",
        modifier = Modifier
            .size(400.dp, 400.dp) // 가로 400, 세로 400 크기로 조정
    )
}

@Composable
fun mainBanner() {
    Spacer(modifier = Modifier.padding(20.dp))
    Text(
        text = "당근마켓",
        color = Color(0xFFE78111),
        fontSize = 50.sp,
        fontFamily = gMarket_bold
    )
    Spacer(modifier = Modifier.padding(20.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarrotCloneTheme {

    }
}